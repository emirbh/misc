package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.Regime;
import cdm.legaldocumentation.csa.validation.RegimeTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.RegimeValidator;
import cdm.legaldocumentation.csa.validation.exists.RegimeOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=Regime.class)
public class RegimeMeta implements RosettaMetaData<Regime> {

	@Override
	public List<Validator<? super Regime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Regime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Regime> validator(ValidatorFactory factory) {
		return factory.<Regime>create(RegimeValidator.class);
	}

	@Override
	public Validator<? super Regime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Regime>create(RegimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Regime> validator() {
		return new RegimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Regime> typeFormatValidator() {
		return new RegimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Regime, Set<String>> onlyExistsValidator() {
		return new RegimeOnlyExistsValidator();
	}
}
