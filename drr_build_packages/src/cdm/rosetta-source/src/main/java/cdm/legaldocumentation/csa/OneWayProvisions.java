package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.OneWayProvisionsMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify whether One Way Provisions apply.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(aa)" * name "One Way Provisions"
 *
 * Provision 
 *
 */
@RosettaDataType(value="OneWayProvisions", builder=OneWayProvisions.OneWayProvisionsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="OneWayProvisions", model="cdm", builder=OneWayProvisions.OneWayProvisionsBuilderImpl.class, version="6.23.0")
public interface OneWayProvisions extends RosettaModelObject {

	OneWayProvisionsMeta metaData = new OneWayProvisionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The determination of whether the One Way Provisions are applicable (true) or not applicable (false).
	 */
	Boolean getIsApplicable();
	/**
	 * The Posting Party for the purposes of One Way Provisions. It is specified in the case where the One Way Provision is deemed applicable.
	 */
	CounterpartyRoleEnum getPostingParty();

	/*********************** Build Methods  ***********************/
	OneWayProvisions build();
	
	OneWayProvisions.OneWayProvisionsBuilder toBuilder();
	
	static OneWayProvisions.OneWayProvisionsBuilder builder() {
		return new OneWayProvisions.OneWayProvisionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OneWayProvisions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OneWayProvisions> getType() {
		return OneWayProvisions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("postingParty"), CounterpartyRoleEnum.class, getPostingParty(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OneWayProvisionsBuilder extends OneWayProvisions, RosettaModelObjectBuilder {
		OneWayProvisions.OneWayProvisionsBuilder setIsApplicable(Boolean isApplicable);
		OneWayProvisions.OneWayProvisionsBuilder setPostingParty(CounterpartyRoleEnum postingParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("postingParty"), CounterpartyRoleEnum.class, getPostingParty(), this);
		}
		

		OneWayProvisions.OneWayProvisionsBuilder prune();
	}

	/*********************** Immutable Implementation of OneWayProvisions  ***********************/
	class OneWayProvisionsImpl implements OneWayProvisions {
		private final Boolean isApplicable;
		private final CounterpartyRoleEnum postingParty;
		
		protected OneWayProvisionsImpl(OneWayProvisions.OneWayProvisionsBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.postingParty = builder.getPostingParty();
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("postingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postingParty")
		public CounterpartyRoleEnum getPostingParty() {
			return postingParty;
		}
		
		@Override
		public OneWayProvisions build() {
			return this;
		}
		
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder toBuilder() {
			OneWayProvisions.OneWayProvisionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OneWayProvisions.OneWayProvisionsBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getPostingParty()).ifPresent(builder::setPostingParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OneWayProvisions _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(postingParty, _that.getPostingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (postingParty != null ? postingParty.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OneWayProvisions {" +
				"isApplicable=" + this.isApplicable + ", " +
				"postingParty=" + this.postingParty +
			'}';
		}
	}

	/*********************** Builder Implementation of OneWayProvisions  ***********************/
	class OneWayProvisionsBuilderImpl implements OneWayProvisions.OneWayProvisionsBuilder {
	
		protected Boolean isApplicable;
		protected CounterpartyRoleEnum postingParty;
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("postingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postingParty")
		public CounterpartyRoleEnum getPostingParty() {
			return postingParty;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("postingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("postingParty")
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder setPostingParty(CounterpartyRoleEnum _postingParty) {
			this.postingParty = _postingParty == null ? null : _postingParty;
			return this;
		}
		
		@Override
		public OneWayProvisions build() {
			return new OneWayProvisions.OneWayProvisionsImpl(this);
		}
		
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getPostingParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OneWayProvisions.OneWayProvisionsBuilder o = (OneWayProvisions.OneWayProvisionsBuilder) other;
			
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getPostingParty(), o.getPostingParty(), this::setPostingParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OneWayProvisions _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(postingParty, _that.getPostingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (postingParty != null ? postingParty.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OneWayProvisionsBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"postingParty=" + this.postingParty +
			'}';
		}
	}
}
