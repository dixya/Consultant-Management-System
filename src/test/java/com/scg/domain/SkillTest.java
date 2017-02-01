/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for {@link Skill}
 * @author dixya
 */
public class SkillTest {
    
    @Test
    public void testSkillEnum() {
        Assert.assertEquals(Skill.PROJECT_MANAGER, Skill.values()[0]);
    }
    
}
