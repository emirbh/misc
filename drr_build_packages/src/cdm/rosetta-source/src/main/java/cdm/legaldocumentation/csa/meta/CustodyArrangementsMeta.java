package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CustodyArrangements;
import cdm.legaldocumentation.csa.validation.CustodyArrangementsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CustodyArrangementsValidator;
import cdm.legaldocumentation.csa.validation.exists.CustodyArrangementsOnlyExistsValidator;
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
@RosettaMeta(model=CustodyArrangements.class)
public class CustodyArrangementsMeta implements RosettaMetaData<CustodyArrangements> {

	@Override
	public List<Validator<? super CustodyArrangements>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustodyArrangements, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodyArrangements> validator(ValidatorFactory factory) {
		return factory.<CustodyArrangements>create(CustodyArrangementsValidator.class);
	}

	@Override
	public Validator<? super CustodyArrangements> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CustodyArrangements>create(CustodyArrangementsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CustodyArrangements> validator() {
		return new CustodyArrangementsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CustodyArrangements> typeFormatValidator() {
		return new CustodyArrangementsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodyArrangements, Set<String>> onlyExistsValidator() {
		return new CustodyArrangementsOnlyExistsValidator();
	}
}
