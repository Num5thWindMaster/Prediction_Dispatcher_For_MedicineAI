package com.lovemyhome.medicine_ai.dldispatcher.commons;// -*- coding: utf-8 -*-            

import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.depict.DepictionGenerator;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.interfaces.IChemObjectBuilder;
import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

// @Author : HaiqingSun
// @Time : 2023/12/14 11:53
public class Utils {
    public static String getBase64(String smiles) {
        try {
            // 使用CDK解析SMILES字符串为分子对象
            IChemObjectBuilder builder = DefaultChemObjectBuilder.getInstance();
            SmilesParser smilesParser = new SmilesParser(builder);
            IAtomContainer molecule = smilesParser.parseSmiles(smiles);

            // 必要时添加氢原子
            AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(molecule);
            AtomContainerManipulator.convertImplicitToExplicitHydrogens(molecule);

            // 生成矢量图
            DepictionGenerator depictionGenerator = new DepictionGenerator();
            String svg = depictionGenerator.depict(molecule).toSvgStr();
            return encodeSVGToBase64(svg);
//             将图像转换为Base64编码
//            String base64Image = encodeImageToBase64(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String encodeImageToBase64(BufferedImage image) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "svg", bos);
        byte[] imageBytes = bos.toByteArray();
        bos.close();

        return Base64.getEncoder().encodeToString(imageBytes);
    }
    private static String encodeSVGToBase64(String svgString) {
        return Base64.getEncoder().encodeToString(svgString.getBytes());
    }
}
