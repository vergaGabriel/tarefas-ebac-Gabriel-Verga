package br.com.gverga;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses( {ClienteServiceTest.class, ContratoServiceTest.class })
public class AllTest {
}
