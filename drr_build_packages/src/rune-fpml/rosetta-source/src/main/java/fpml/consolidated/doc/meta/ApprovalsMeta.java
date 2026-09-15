package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Approvals;
import fpml.consolidated.doc.validation.ApprovalsTypeFormatValidator;
import fpml.consolidated.doc.validation.ApprovalsValidator;
import fpml.consolidated.doc.validation.exists.ApprovalsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Approvals.class)
public class ApprovalsMeta implements RosettaMetaData<Approvals> {

	@Override
	public List<Validator<? super Approvals>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Approvals, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Approvals> validator(ValidatorFactory factory) {
		return factory.<Approvals>create(ApprovalsValidator.class);
	}

	@Override
	public Validator<? super Approvals> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Approvals>create(ApprovalsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Approvals> validator() {
		return new ApprovalsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Approvals> typeFormatValidator() {
		return new ApprovalsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Approvals, Set<String>> onlyExistsValidator() {
		return new ApprovalsOnlyExistsValidator();
	}
}
