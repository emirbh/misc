package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.doc.validation.ReportingRoleTypeFormatValidator;
import fpml.consolidated.doc.validation.ReportingRoleValidator;
import fpml.consolidated.doc.validation.exists.ReportingRoleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReportingRole.class)
public class ReportingRoleMeta implements RosettaMetaData<ReportingRole> {

	@Override
	public List<Validator<? super ReportingRole>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingRole, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportingRole> validator(ValidatorFactory factory) {
		return factory.<ReportingRole>create(ReportingRoleValidator.class);
	}

	@Override
	public Validator<? super ReportingRole> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportingRole>create(ReportingRoleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportingRole> validator() {
		return new ReportingRoleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportingRole> typeFormatValidator() {
		return new ReportingRoleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingRole, Set<String>> onlyExistsValidator() {
		return new ReportingRoleOnlyExistsValidator();
	}
}
