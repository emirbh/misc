package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegReportingPackageInfo;
import fpml.consolidated.recordkeeping.processes.validation.RegReportingPackageInfoTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegReportingPackageInfoValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegReportingPackageInfoOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegReportingPackageInfo.class)
public class RegReportingPackageInfoMeta implements RosettaMetaData<RegReportingPackageInfo> {

	@Override
	public List<Validator<? super RegReportingPackageInfo>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegReportingPackageInfo, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegReportingPackageInfo> validator(ValidatorFactory factory) {
		return factory.<RegReportingPackageInfo>create(RegReportingPackageInfoValidator.class);
	}

	@Override
	public Validator<? super RegReportingPackageInfo> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegReportingPackageInfo>create(RegReportingPackageInfoTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegReportingPackageInfo> validator() {
		return new RegReportingPackageInfoValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegReportingPackageInfo> typeFormatValidator() {
		return new RegReportingPackageInfoTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegReportingPackageInfo, Set<String>> onlyExistsValidator() {
		return new RegReportingPackageInfoOnlyExistsValidator();
	}
}
