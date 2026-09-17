package fpml.consolidated;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.meta.SignatureMethodMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="SignatureMethod", builder=SignatureMethod.SignatureMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SignatureMethod", model="fpml", builder=SignatureMethod.SignatureMethodBuilderImpl.class, version="2.1.1")
public interface SignatureMethod extends SignatureMethodType {

	SignatureMethodMeta metaData = new SignatureMethodMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SignatureMethod build();
	
	SignatureMethod.SignatureMethodBuilder toBuilder();
	
	static SignatureMethod.SignatureMethodBuilder builder() {
		return new SignatureMethod.SignatureMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SignatureMethod> getType() {
		return SignatureMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		processor.processBasic(path.newSubPath("hmacOutputLength"), Integer.class, getHmacOutputLength(), this);
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignatureMethodBuilder extends SignatureMethod, SignatureMethodType.SignatureMethodTypeBuilder {
		@Override
		SignatureMethod.SignatureMethodBuilder setAlgorithm(String algorithm);
		@Override
		SignatureMethod.SignatureMethodBuilder setHmacOutputLength(Integer hmacOutputLength);
		@Override
		SignatureMethod.SignatureMethodBuilder addAnyContents(String anyContents);
		@Override
		SignatureMethod.SignatureMethodBuilder addAnyContents(String anyContents, int idx);
		@Override
		SignatureMethod.SignatureMethodBuilder addAnyContents(List<String> anyContents);
		@Override
		SignatureMethod.SignatureMethodBuilder setAnyContents(List<String> anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
			processor.processBasic(path.newSubPath("hmacOutputLength"), Integer.class, getHmacOutputLength(), this);
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		SignatureMethod.SignatureMethodBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureMethod  ***********************/
	class SignatureMethodImpl extends SignatureMethodType.SignatureMethodTypeImpl implements SignatureMethod {
		
		protected SignatureMethodImpl(SignatureMethod.SignatureMethodBuilder builder) {
			super(builder);
		}
		
		@Override
		public SignatureMethod build() {
			return this;
		}
		
		@Override
		public SignatureMethod.SignatureMethodBuilder toBuilder() {
			SignatureMethod.SignatureMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureMethod.SignatureMethodBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureMethod {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SignatureMethod  ***********************/
	class SignatureMethodBuilderImpl extends SignatureMethodType.SignatureMethodTypeBuilderImpl implements SignatureMethod.SignatureMethodBuilder {
	
		
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("algorithm")
		@Override
		public SignatureMethod.SignatureMethodBuilder setAlgorithm(String _algorithm) {
			this.algorithm = _algorithm == null ? null : _algorithm;
			return this;
		}
		
		@RosettaAttribute("hmacOutputLength")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("hmacOutputLength")
		@Override
		public SignatureMethod.SignatureMethodBuilder setHmacOutputLength(Integer _hmacOutputLength) {
			this.hmacOutputLength = _hmacOutputLength == null ? null : _hmacOutputLength;
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("anyContents")
		@Override
		public SignatureMethod.SignatureMethodBuilder addAnyContents(String _anyContents) {
			if (_anyContents != null) {
				this.anyContents.add(_anyContents);
			}
			return this;
		}
		
		@Override
		public SignatureMethod.SignatureMethodBuilder addAnyContents(String _anyContents, int idx) {
			getIndex(this.anyContents, idx, () -> _anyContents);
			return this;
		}
		
		@Override
		public SignatureMethod.SignatureMethodBuilder addAnyContents(List<String> anyContentss) {
			if (anyContentss != null) {
				for (final String toAdd : anyContentss) {
					this.anyContents.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("anyContents")
		@Override
		public SignatureMethod.SignatureMethodBuilder setAnyContents(List<String> anyContentss) {
			if (anyContentss == null) {
				this.anyContents = new ArrayList<>();
			} else {
				this.anyContents = anyContentss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SignatureMethod build() {
			return new SignatureMethod.SignatureMethodImpl(this);
		}
		
		@Override
		public SignatureMethod.SignatureMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureMethod.SignatureMethodBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureMethod.SignatureMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SignatureMethod.SignatureMethodBuilder o = (SignatureMethod.SignatureMethodBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignatureMethodBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
