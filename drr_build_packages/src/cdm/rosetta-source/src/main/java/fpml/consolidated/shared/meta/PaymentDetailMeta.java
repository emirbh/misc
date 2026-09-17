package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PaymentDetail;
import fpml.consolidated.shared.validation.PaymentDetailTypeFormatValidator;
import fpml.consolidated.shared.validation.PaymentDetailValidator;
import fpml.consolidated.shared.validation.exists.PaymentDetailOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PaymentDetail.class)
public class PaymentDetailMeta implements RosettaMetaData<PaymentDetail> {

	@Override
	public List<Validator<? super PaymentDetail>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentDetail, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaymentDetail> validator(ValidatorFactory factory) {
		return factory.<PaymentDetail>create(PaymentDetailValidator.class);
	}

	@Override
	public Validator<? super PaymentDetail> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaymentDetail>create(PaymentDetailTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaymentDetail> validator() {
		return new PaymentDetailValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PaymentDetail> typeFormatValidator() {
		return new PaymentDetailTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentDetail, Set<String>> onlyExistsValidator() {
		return new PaymentDetailOnlyExistsValidator();
	}
}
