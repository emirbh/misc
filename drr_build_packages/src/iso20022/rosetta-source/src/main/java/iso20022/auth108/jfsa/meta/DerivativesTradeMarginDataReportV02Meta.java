package iso20022.auth108.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.jfsa.DerivativesTradeMarginDataReportV02;
import iso20022.auth108.jfsa.validation.DerivativesTradeMarginDataReportV02TypeFormatValidator;
import iso20022.auth108.jfsa.validation.DerivativesTradeMarginDataReportV02Validator;
import iso20022.auth108.jfsa.validation.exists.DerivativesTradeMarginDataReportV02OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativesTradeMarginDataReportV02.class)
public class DerivativesTradeMarginDataReportV02Meta implements RosettaMetaData<DerivativesTradeMarginDataReportV02> {

	@Override
	public List<Validator<? super DerivativesTradeMarginDataReportV02>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativesTradeMarginDataReportV02, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativesTradeMarginDataReportV02> validator(ValidatorFactory factory) {
		return factory.<DerivativesTradeMarginDataReportV02>create(DerivativesTradeMarginDataReportV02Validator.class);
	}

	@Override
	public Validator<? super DerivativesTradeMarginDataReportV02> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativesTradeMarginDataReportV02>create(DerivativesTradeMarginDataReportV02TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativesTradeMarginDataReportV02> validator() {
		return new DerivativesTradeMarginDataReportV02Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativesTradeMarginDataReportV02> typeFormatValidator() {
		return new DerivativesTradeMarginDataReportV02TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativesTradeMarginDataReportV02, Set<String>> onlyExistsValidator() {
		return new DerivativesTradeMarginDataReportV02OnlyExistsValidator();
	}
}
