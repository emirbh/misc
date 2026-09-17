package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.AllocationReportingStatus;
import fpml.consolidated.doc.validation.AllocationReportingStatusTypeFormatValidator;
import fpml.consolidated.doc.validation.AllocationReportingStatusValidator;
import fpml.consolidated.doc.validation.exists.AllocationReportingStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AllocationReportingStatus.class)
public class AllocationReportingStatusMeta implements RosettaMetaData<AllocationReportingStatus> {

	@Override
	public List<Validator<? super AllocationReportingStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllocationReportingStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AllocationReportingStatus> validator(ValidatorFactory factory) {
		return factory.<AllocationReportingStatus>create(AllocationReportingStatusValidator.class);
	}

	@Override
	public Validator<? super AllocationReportingStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AllocationReportingStatus>create(AllocationReportingStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AllocationReportingStatus> validator() {
		return new AllocationReportingStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AllocationReportingStatus> typeFormatValidator() {
		return new AllocationReportingStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllocationReportingStatus, Set<String>> onlyExistsValidator() {
		return new AllocationReportingStatusOnlyExistsValidator();
	}
}
