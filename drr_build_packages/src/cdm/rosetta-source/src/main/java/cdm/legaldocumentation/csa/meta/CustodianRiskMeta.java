package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CustodianRisk;
import cdm.legaldocumentation.csa.validation.CustodianRiskTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CustodianRiskValidator;
import cdm.legaldocumentation.csa.validation.exists.CustodianRiskOnlyExistsValidator;
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
@RosettaMeta(model=CustodianRisk.class)
public class CustodianRiskMeta implements RosettaMetaData<CustodianRisk> {

	@Override
	public List<Validator<? super CustodianRisk>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustodianRisk, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodianRisk> validator(ValidatorFactory factory) {
		return factory.<CustodianRisk>create(CustodianRiskValidator.class);
	}

	@Override
	public Validator<? super CustodianRisk> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CustodianRisk>create(CustodianRiskTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CustodianRisk> validator() {
		return new CustodianRiskValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CustodianRisk> typeFormatValidator() {
		return new CustodianRiskTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodianRisk, Set<String>> onlyExistsValidator() {
		return new CustodianRiskOnlyExistsValidator();
	}
}
