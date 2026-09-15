package org.iso20022;

import com.google.inject.AbstractModule;
import com.rosetta.model.lib.ModuleConfig;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.validation.ValidatorFactory;

@ModuleConfig(model = "ISO-20022", type = "Rosetta")
public class Iso20022RuntimeModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(QualifyFunctionFactory.class).to(QualifyFunctionFactory.Default.class);
        bind(ValidatorFactory.class).to(ValidatorFactory.Default.class);
    }
}