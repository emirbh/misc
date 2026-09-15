package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ReportableDelivery;
import drr.regulation.common.validation.ReportableDeliveryTypeFormatValidator;
import drr.regulation.common.validation.ReportableDeliveryValidator;
import drr.regulation.common.validation.exists.ReportableDeliveryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportableDelivery.class)
public class ReportableDeliveryMeta implements RosettaMetaData<ReportableDelivery> {

	@Override
	public List<Validator<? super ReportableDelivery>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportableDelivery, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportableDelivery> validator(ValidatorFactory factory) {
		return factory.<ReportableDelivery>create(ReportableDeliveryValidator.class);
	}

	@Override
	public Validator<? super ReportableDelivery> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportableDelivery>create(ReportableDeliveryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportableDelivery> validator() {
		return new ReportableDeliveryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportableDelivery> typeFormatValidator() {
		return new ReportableDeliveryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportableDelivery, Set<String>> onlyExistsValidator() {
		return new ReportableDeliveryOnlyExistsValidator();
	}
}
