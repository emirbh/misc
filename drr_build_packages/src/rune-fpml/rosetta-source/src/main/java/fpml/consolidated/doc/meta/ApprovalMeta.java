package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Approval;
import fpml.consolidated.doc.validation.ApprovalTypeFormatValidator;
import fpml.consolidated.doc.validation.ApprovalValidator;
import fpml.consolidated.doc.validation.exists.ApprovalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Approval.class)
public class ApprovalMeta implements RosettaMetaData<Approval> {

	@Override
	public List<Validator<? super Approval>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Approval, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Approval> validator(ValidatorFactory factory) {
		return factory.<Approval>create(ApprovalValidator.class);
	}

	@Override
	public Validator<? super Approval> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Approval>create(ApprovalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Approval> validator() {
		return new ApprovalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Approval> typeFormatValidator() {
		return new ApprovalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Approval, Set<String>> onlyExistsValidator() {
		return new ApprovalOnlyExistsValidator();
	}
}
