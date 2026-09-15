package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.DocumentVoteDecisionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to identify a documented vote decision type (e.g. a vote decision type based on legal documentation).
 *
 */
@RosettaDataType(value="DocumentVoteDecisionType", builder=DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DocumentVoteDecisionType", model="fpml", builder=DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilderImpl.class, version="2.1.1")
public interface DocumentVoteDecisionType extends RosettaModelObject {

	DocumentVoteDecisionTypeMeta metaData = new DocumentVoteDecisionTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getVoteDecisionTypeScheme();

	/*********************** Build Methods  ***********************/
	DocumentVoteDecisionType build();
	
	DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder toBuilder();
	
	static DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder builder() {
		return new DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DocumentVoteDecisionType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DocumentVoteDecisionType> getType() {
		return DocumentVoteDecisionType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("voteDecisionTypeScheme"), String.class, getVoteDecisionTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DocumentVoteDecisionTypeBuilder extends DocumentVoteDecisionType, RosettaModelObjectBuilder {
		DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder setValue(String value);
		DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder setVoteDecisionTypeScheme(String voteDecisionTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("voteDecisionTypeScheme"), String.class, getVoteDecisionTypeScheme(), this);
		}
		

		DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of DocumentVoteDecisionType  ***********************/
	class DocumentVoteDecisionTypeImpl implements DocumentVoteDecisionType {
		private final String value;
		private final String voteDecisionTypeScheme;
		
		protected DocumentVoteDecisionTypeImpl(DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder builder) {
			this.value = builder.getValue();
			this.voteDecisionTypeScheme = builder.getVoteDecisionTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("voteDecisionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("voteDecisionTypeScheme")
		public String getVoteDecisionTypeScheme() {
			return voteDecisionTypeScheme;
		}
		
		@Override
		public DocumentVoteDecisionType build() {
			return this;
		}
		
		@Override
		public DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder toBuilder() {
			DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getVoteDecisionTypeScheme()).ifPresent(builder::setVoteDecisionTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DocumentVoteDecisionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(voteDecisionTypeScheme, _that.getVoteDecisionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (voteDecisionTypeScheme != null ? voteDecisionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentVoteDecisionType {" +
				"value=" + this.value + ", " +
				"voteDecisionTypeScheme=" + this.voteDecisionTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of DocumentVoteDecisionType  ***********************/
	class DocumentVoteDecisionTypeBuilderImpl implements DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder {
	
		protected String value;
		protected String voteDecisionTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("voteDecisionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("voteDecisionTypeScheme")
		public String getVoteDecisionTypeScheme() {
			return voteDecisionTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("voteDecisionTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("voteDecisionTypeScheme")
		@Override
		public DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder setVoteDecisionTypeScheme(String _voteDecisionTypeScheme) {
			this.voteDecisionTypeScheme = _voteDecisionTypeScheme == null ? null : _voteDecisionTypeScheme;
			return this;
		}
		
		@Override
		public DocumentVoteDecisionType build() {
			return new DocumentVoteDecisionType.DocumentVoteDecisionTypeImpl(this);
		}
		
		@Override
		public DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getVoteDecisionTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder o = (DocumentVoteDecisionType.DocumentVoteDecisionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getVoteDecisionTypeScheme(), o.getVoteDecisionTypeScheme(), this::setVoteDecisionTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DocumentVoteDecisionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(voteDecisionTypeScheme, _that.getVoteDecisionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (voteDecisionTypeScheme != null ? voteDecisionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentVoteDecisionTypeBuilder {" +
				"value=" + this.value + ", " +
				"voteDecisionTypeScheme=" + this.voteDecisionTypeScheme +
			'}';
		}
	}
}
