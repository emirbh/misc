package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.HarmonizedData;
import iso20022.dtcc.rds.harmonized.validation.HarmonizedDataTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.HarmonizedDataValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.HarmonizedDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=HarmonizedData.class)
public class HarmonizedDataMeta implements RosettaMetaData<HarmonizedData> {

	@Override
	public List<Validator<? super HarmonizedData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super HarmonizedData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super HarmonizedData> validator(ValidatorFactory factory) {
		return factory.<HarmonizedData>create(HarmonizedDataValidator.class);
	}

	@Override
	public Validator<? super HarmonizedData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<HarmonizedData>create(HarmonizedDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super HarmonizedData> validator() {
		return new HarmonizedDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super HarmonizedData> typeFormatValidator() {
		return new HarmonizedDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super HarmonizedData, Set<String>> onlyExistsValidator() {
		return new HarmonizedDataOnlyExistsValidator();
	}
}
