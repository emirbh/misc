package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.MgmtData;
import fpml.consolidated.validation.MgmtDataTypeFormatValidator;
import fpml.consolidated.validation.MgmtDataValidator;
import fpml.consolidated.validation.exists.MgmtDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MgmtData.class)
public class MgmtDataMeta implements RosettaMetaData<MgmtData> {

	@Override
	public List<Validator<? super MgmtData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MgmtData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MgmtData> validator(ValidatorFactory factory) {
		return factory.<MgmtData>create(MgmtDataValidator.class);
	}

	@Override
	public Validator<? super MgmtData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MgmtData>create(MgmtDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MgmtData> validator() {
		return new MgmtDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MgmtData> typeFormatValidator() {
		return new MgmtDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MgmtData, Set<String>> onlyExistsValidator() {
		return new MgmtDataOnlyExistsValidator();
	}
}
