package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.HarmonizedRepeatableData;
import iso20022.dtcc.rds.harmonized.validation.HarmonizedRepeatableDataTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.HarmonizedRepeatableDataValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.HarmonizedRepeatableDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=HarmonizedRepeatableData.class)
public class HarmonizedRepeatableDataMeta implements RosettaMetaData<HarmonizedRepeatableData> {

	@Override
	public List<Validator<? super HarmonizedRepeatableData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super HarmonizedRepeatableData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super HarmonizedRepeatableData> validator(ValidatorFactory factory) {
		return factory.<HarmonizedRepeatableData>create(HarmonizedRepeatableDataValidator.class);
	}

	@Override
	public Validator<? super HarmonizedRepeatableData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<HarmonizedRepeatableData>create(HarmonizedRepeatableDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super HarmonizedRepeatableData> validator() {
		return new HarmonizedRepeatableDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super HarmonizedRepeatableData> typeFormatValidator() {
		return new HarmonizedRepeatableDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super HarmonizedRepeatableData, Set<String>> onlyExistsValidator() {
		return new HarmonizedRepeatableDataOnlyExistsValidator();
	}
}
