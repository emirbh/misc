package iso20022.auth108.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.fca.DerivativesTradeMarginDataReportV01;
import iso20022.auth108.fca.validation.DerivativesTradeMarginDataReportV01TypeFormatValidator;
import iso20022.auth108.fca.validation.DerivativesTradeMarginDataReportV01Validator;
import iso20022.auth108.fca.validation.exists.DerivativesTradeMarginDataReportV01OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativesTradeMarginDataReportV01.class)
public class DerivativesTradeMarginDataReportV01Meta implements RosettaMetaData<DerivativesTradeMarginDataReportV01> {

	@Override
	public List<Validator<? super DerivativesTradeMarginDataReportV01>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativesTradeMarginDataReportV01, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativesTradeMarginDataReportV01> validator(ValidatorFactory factory) {
		return factory.<DerivativesTradeMarginDataReportV01>create(DerivativesTradeMarginDataReportV01Validator.class);
	}

	@Override
	public Validator<? super DerivativesTradeMarginDataReportV01> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativesTradeMarginDataReportV01>create(DerivativesTradeMarginDataReportV01TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativesTradeMarginDataReportV01> validator() {
		return new DerivativesTradeMarginDataReportV01Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativesTradeMarginDataReportV01> typeFormatValidator() {
		return new DerivativesTradeMarginDataReportV01TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativesTradeMarginDataReportV01, Set<String>> onlyExistsValidator() {
		return new DerivativesTradeMarginDataReportV01OnlyExistsValidator();
	}
}
