package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbCDSIndex;
import drr.standards.iosco.upi.validation.AnnaDsbCDSIndexTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbCDSIndexValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbCDSIndexOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbCDSIndex.class)
public class AnnaDsbCDSIndexMeta implements RosettaMetaData<AnnaDsbCDSIndex> {

	@Override
	public List<Validator<? super AnnaDsbCDSIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbCDSIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbCDSIndex> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbCDSIndex>create(AnnaDsbCDSIndexValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbCDSIndex> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbCDSIndex>create(AnnaDsbCDSIndexTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbCDSIndex> validator() {
		return new AnnaDsbCDSIndexValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbCDSIndex> typeFormatValidator() {
		return new AnnaDsbCDSIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbCDSIndex, Set<String>> onlyExistsValidator() {
		return new AnnaDsbCDSIndexOnlyExistsValidator();
	}
}
