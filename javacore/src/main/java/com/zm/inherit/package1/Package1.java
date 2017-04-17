package com.zm.inherit.package1;

import com.zm.inherit.package2.Package2;
import jdk.internal.org.objectweb.asm.commons.AnalyzerAdapter;
import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;
import org.junit.Test;

/**
 * Created by Administrator on 2017/4/1.
 */
public class Package1 {

    private String package1;

    private Package2 package2;

    @Test
    public void setPackage1(String package1){
        this.package1 = package1 + package2.toString();
    }
}
