package fpml.consolidated;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.meta.SignaturePropertyTypeChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

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
@RosettaDataType(value="SignaturePropertyTypeChoice", builder=SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SignaturePropertyTypeChoice", model="fpml", builder=SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilderImpl.class, version="2.1.1")
public interface SignaturePropertyTypeChoice extends RosettaModelObject {

	SignaturePropertyTypeChoiceMeta metaData = new SignaturePropertyTypeChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##other; Process Contents: lax.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##other; Process Contents: lax.
	 *
	 */
	String getAnyContents();

	/*********************** Build Methods  ***********************/
	SignaturePropertyTypeChoice build();
	
	SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder toBuilder();
	
	static SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder builder() {
		return new SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignaturePropertyTypeChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SignaturePropertyTypeChoice> getType() {
		return SignaturePropertyTypeChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignaturePropertyTypeChoiceBuilder extends SignaturePropertyTypeChoice, RosettaModelObjectBuilder {
		SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder setAnyContents(String anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of SignaturePropertyTypeChoice  ***********************/
	class SignaturePropertyTypeChoiceImpl implements SignaturePropertyTypeChoice {
		private final String anyContents;
		
		protected SignaturePropertyTypeChoiceImpl(SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder builder) {
			this.anyContents = builder.getAnyContents();
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@Override
		public SignaturePropertyTypeChoice build() {
			return this;
		}
		
		@Override
		public SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder toBuilder() {
			SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder builder) {
			ofNullable(getAnyContents()).ifPresent(builder::setAnyContents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignaturePropertyTypeChoice _that = getType().cast(o);
		
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertyTypeChoice {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}

	/*********************** Builder Implementation of SignaturePropertyTypeChoice  ***********************/
	class SignaturePropertyTypeChoiceBuilderImpl implements SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder {
	
		protected String anyContents;
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("anyContents")
		@Override
		public SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder setAnyContents(String _anyContents) {
			this.anyContents = _anyContents == null ? null : _anyContents;
			return this;
		}
		
		@Override
		public SignaturePropertyTypeChoice build() {
			return new SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceImpl(this);
		}
		
		@Override
		public SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAnyContents()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder o = (SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder) other;
			
			
			merger.mergeBasic(getAnyContents(), o.getAnyContents(), this::setAnyContents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignaturePropertyTypeChoice _that = getType().cast(o);
		
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertyTypeChoiceBuilder {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}
}
