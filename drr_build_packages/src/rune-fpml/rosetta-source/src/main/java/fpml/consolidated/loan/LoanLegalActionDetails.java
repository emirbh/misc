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
import fpml.consolidated.loan.meta.LoanLegalActionDetailsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure to describe details of the legal action.
 *
 */
@RosettaDataType(value="LoanLegalActionDetails", builder=LoanLegalActionDetails.LoanLegalActionDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionDetails", model="fpml", builder=LoanLegalActionDetails.LoanLegalActionDetailsBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionDetails extends RosettaModelObject {

	LoanLegalActionDetailsMeta metaData = new LoanLegalActionDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure used to uniquely identify a legal action type.
	 *
	 */
	LoanLegalActionType getLegalActionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A freetext field which allows the sender to describe the legal action.
	 *
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	LoanLegalActionDetails build();
	
	LoanLegalActionDetails.LoanLegalActionDetailsBuilder toBuilder();
	
	static LoanLegalActionDetails.LoanLegalActionDetailsBuilder builder() {
		return new LoanLegalActionDetails.LoanLegalActionDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionDetails> getType() {
		return LoanLegalActionDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("legalActionType"), processor, LoanLegalActionType.class, getLegalActionType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionDetailsBuilder extends LoanLegalActionDetails, RosettaModelObjectBuilder {
		LoanLegalActionType.LoanLegalActionTypeBuilder getOrCreateLegalActionType();
		@Override
		LoanLegalActionType.LoanLegalActionTypeBuilder getLegalActionType();
		LoanLegalActionDetails.LoanLegalActionDetailsBuilder setLegalActionType(LoanLegalActionType legalActionType);
		LoanLegalActionDetails.LoanLegalActionDetailsBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("legalActionType"), processor, LoanLegalActionType.LoanLegalActionTypeBuilder.class, getLegalActionType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		LoanLegalActionDetails.LoanLegalActionDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionDetails  ***********************/
	class LoanLegalActionDetailsImpl implements LoanLegalActionDetails {
		private final LoanLegalActionType legalActionType;
		private final String description;
		
		protected LoanLegalActionDetailsImpl(LoanLegalActionDetails.LoanLegalActionDetailsBuilder builder) {
			this.legalActionType = ofNullable(builder.getLegalActionType()).map(f->f.build()).orElse(null);
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("legalActionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalActionType")
		public LoanLegalActionType getLegalActionType() {
			return legalActionType;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public LoanLegalActionDetails build() {
			return this;
		}
		
		@Override
		public LoanLegalActionDetails.LoanLegalActionDetailsBuilder toBuilder() {
			LoanLegalActionDetails.LoanLegalActionDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionDetails.LoanLegalActionDetailsBuilder builder) {
			ofNullable(getLegalActionType()).ifPresent(builder::setLegalActionType);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionDetails _that = getType().cast(o);
		
			if (!Objects.equals(legalActionType, _that.getLegalActionType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legalActionType != null ? legalActionType.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionDetails {" +
				"legalActionType=" + this.legalActionType + ", " +
				"description=" + this.description +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionDetails  ***********************/
	class LoanLegalActionDetailsBuilderImpl implements LoanLegalActionDetails.LoanLegalActionDetailsBuilder {
	
		protected LoanLegalActionType.LoanLegalActionTypeBuilder legalActionType;
		protected String description;
		
		@Override
		@RosettaAttribute("legalActionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("legalActionType")
		public LoanLegalActionType.LoanLegalActionTypeBuilder getLegalActionType() {
			return legalActionType;
		}
		
		@Override
		public LoanLegalActionType.LoanLegalActionTypeBuilder getOrCreateLegalActionType() {
			LoanLegalActionType.LoanLegalActionTypeBuilder result;
			if (legalActionType!=null) {
				result = legalActionType;
			}
			else {
				result = legalActionType = LoanLegalActionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@RosettaAttribute("legalActionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("legalActionType")
		@Override
		public LoanLegalActionDetails.LoanLegalActionDetailsBuilder setLegalActionType(LoanLegalActionType _legalActionType) {
			this.legalActionType = _legalActionType == null ? null : _legalActionType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public LoanLegalActionDetails.LoanLegalActionDetailsBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public LoanLegalActionDetails build() {
			return new LoanLegalActionDetails.LoanLegalActionDetailsImpl(this);
		}
		
		@Override
		public LoanLegalActionDetails.LoanLegalActionDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionDetails.LoanLegalActionDetailsBuilder prune() {
			if (legalActionType!=null && !legalActionType.prune().hasData()) legalActionType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLegalActionType()!=null && getLegalActionType().hasData()) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionDetails.LoanLegalActionDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionDetails.LoanLegalActionDetailsBuilder o = (LoanLegalActionDetails.LoanLegalActionDetailsBuilder) other;
			
			merger.mergeRosetta(getLegalActionType(), o.getLegalActionType(), this::setLegalActionType);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionDetails _that = getType().cast(o);
		
			if (!Objects.equals(legalActionType, _that.getLegalActionType())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legalActionType != null ? legalActionType.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionDetailsBuilder {" +
				"legalActionType=" + this.legalActionType + ", " +
				"description=" + this.description +
			'}';
		}
	}
}
