package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.CreditEventNotice;
import fpml.consolidated.credit.event.notification.validation.CreditEventNoticeTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.CreditEventNoticeValidator;
import fpml.consolidated.credit.event.notification.validation.exists.CreditEventNoticeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditEventNotice.class)
public class CreditEventNoticeMeta implements RosettaMetaData<CreditEventNotice> {

	@Override
	public List<Validator<? super CreditEventNotice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEventNotice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditEventNotice> validator(ValidatorFactory factory) {
		return factory.<CreditEventNotice>create(CreditEventNoticeValidator.class);
	}

	@Override
	public Validator<? super CreditEventNotice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditEventNotice>create(CreditEventNoticeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventNotice> validator() {
		return new CreditEventNoticeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventNotice> typeFormatValidator() {
		return new CreditEventNoticeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEventNotice, Set<String>> onlyExistsValidator() {
		return new CreditEventNoticeOnlyExistsValidator();
	}
}
