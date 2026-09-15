package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.DerivativesTradeReportV04;
import iso20022.auth030.asic.validation.DerivativesTradeReportV04TypeFormatValidator;
import iso20022.auth030.asic.validation.DerivativesTradeReportV04Validator;
import iso20022.auth030.asic.validation.exists.DerivativesTradeReportV04OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativesTradeReportV04.class)
public class DerivativesTradeReportV04Meta implements RosettaMetaData<DerivativesTradeReportV04> {

	@Override
	public List<Validator<? super DerivativesTradeReportV04>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativesTradeReportV04, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativesTradeReportV04> validator(ValidatorFactory factory) {
		return factory.<DerivativesTradeReportV04>create(DerivativesTradeReportV04Validator.class);
	}

	@Override
	public Validator<? super DerivativesTradeReportV04> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativesTradeReportV04>create(DerivativesTradeReportV04TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativesTradeReportV04> validator() {
		return new DerivativesTradeReportV04Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativesTradeReportV04> typeFormatValidator() {
		return new DerivativesTradeReportV04TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativesTradeReportV04, Set<String>> onlyExistsValidator() {
		return new DerivativesTradeReportV04OnlyExistsValidator();
	}
}
