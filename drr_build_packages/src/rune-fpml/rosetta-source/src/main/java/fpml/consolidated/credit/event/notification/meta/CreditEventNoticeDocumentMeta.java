package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.CreditEventNoticeDocument;
import fpml.consolidated.credit.event.notification.validation.CreditEventNoticeDocumentTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.CreditEventNoticeDocumentValidator;
import fpml.consolidated.credit.event.notification.validation.exists.CreditEventNoticeDocumentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditEventNoticeDocument.class)
public class CreditEventNoticeDocumentMeta implements RosettaMetaData<CreditEventNoticeDocument> {

	@Override
	public List<Validator<? super CreditEventNoticeDocument>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEventNoticeDocument, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditEventNoticeDocument> validator(ValidatorFactory factory) {
		return factory.<CreditEventNoticeDocument>create(CreditEventNoticeDocumentValidator.class);
	}

	@Override
	public Validator<? super CreditEventNoticeDocument> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditEventNoticeDocument>create(CreditEventNoticeDocumentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventNoticeDocument> validator() {
		return new CreditEventNoticeDocumentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventNoticeDocument> typeFormatValidator() {
		return new CreditEventNoticeDocumentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEventNoticeDocument, Set<String>> onlyExistsValidator() {
		return new CreditEventNoticeDocumentOnlyExistsValidator();
	}
}
