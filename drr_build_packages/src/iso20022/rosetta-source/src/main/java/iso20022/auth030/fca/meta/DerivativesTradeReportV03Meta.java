package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.DerivativesTradeReportV03;
import iso20022.auth030.fca.validation.DerivativesTradeReportV03TypeFormatValidator;
import iso20022.auth030.fca.validation.DerivativesTradeReportV03Validator;
import iso20022.auth030.fca.validation.exists.DerivativesTradeReportV03OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativesTradeReportV03.class)
public class DerivativesTradeReportV03Meta implements RosettaMetaData<DerivativesTradeReportV03> {

	@Override
	public List<Validator<? super DerivativesTradeReportV03>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativesTradeReportV03, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DerivativesTradeReportV03> validator(ValidatorFactory factory) {
		return factory.<DerivativesTradeReportV03>create(DerivativesTradeReportV03Validator.class);
	}

	@Override
	public Validator<? super DerivativesTradeReportV03> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DerivativesTradeReportV03>create(DerivativesTradeReportV03TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DerivativesTradeReportV03> validator() {
		return new DerivativesTradeReportV03Validator();
	}

	@Deprecated
	@Override
	public Validator<? super DerivativesTradeReportV03> typeFormatValidator() {
		return new DerivativesTradeReportV03TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativesTradeReportV03, Set<String>> onlyExistsValidator() {
		return new DerivativesTradeReportV03OnlyExistsValidator();
	}
}
