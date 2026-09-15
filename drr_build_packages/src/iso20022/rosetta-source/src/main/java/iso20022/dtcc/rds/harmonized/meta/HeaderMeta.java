package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.Header;
import iso20022.dtcc.rds.harmonized.validation.HeaderTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.HeaderValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.HeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Header.class)
public class HeaderMeta implements RosettaMetaData<Header> {

	@Override
	public List<Validator<? super Header>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Header, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Header> validator(ValidatorFactory factory) {
		return factory.<Header>create(HeaderValidator.class);
	}

	@Override
	public Validator<? super Header> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Header>create(HeaderTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Header> validator() {
		return new HeaderValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Header> typeFormatValidator() {
		return new HeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Header, Set<String>> onlyExistsValidator() {
		return new HeaderOnlyExistsValidator();
	}
}
