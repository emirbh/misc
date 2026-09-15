package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegReportingPayment;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegReportingPaymentTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegReportingPaymentValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegReportingPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegReportingPayment.class)
public class RegReportingPaymentMeta implements RosettaMetaData<RegReportingPayment> {

	@Override
	public List<Validator<? super RegReportingPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegReportingPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegReportingPayment> validator(ValidatorFactory factory) {
		return factory.<RegReportingPayment>create(RegReportingPaymentValidator.class);
	}

	@Override
	public Validator<? super RegReportingPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegReportingPayment>create(RegReportingPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegReportingPayment> validator() {
		return new RegReportingPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegReportingPayment> typeFormatValidator() {
		return new RegReportingPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegReportingPayment, Set<String>> onlyExistsValidator() {
		return new RegReportingPaymentOnlyExistsValidator();
	}
}
