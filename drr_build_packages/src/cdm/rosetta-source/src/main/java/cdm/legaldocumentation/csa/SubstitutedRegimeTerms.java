package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.SubstitutedRegimeTermsMeta;
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
 * Specifies the applicability of the Substituted Regime as denoted in the Substituted Regime Table as part of certain legal agreements, such as such as the ISDA 2016 and 2018 CSA for Initial Margin.
 * @version 6.23.0
 */
@RosettaDataType(value="SubstitutedRegimeTerms", builder=SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SubstitutedRegimeTerms", model="cdm", builder=SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilderImpl.class, version="6.23.0")
public interface SubstitutedRegimeTerms extends RosettaModelObject {

	SubstitutedRegimeTermsMeta metaData = new SubstitutedRegimeTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party for which the regime terms are being specified when acting as collateral taker.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The specification of whether the regime is elected as applicable to the party when acting as collateral taker.
	 */
	Boolean getIsApplicable();

	/*********************** Build Methods  ***********************/
	SubstitutedRegimeTerms build();
	
	SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder toBuilder();
	
	static SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder builder() {
		return new SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SubstitutedRegimeTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SubstitutedRegimeTerms> getType() {
		return SubstitutedRegimeTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SubstitutedRegimeTermsBuilder extends SubstitutedRegimeTerms, RosettaModelObjectBuilder {
		SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder setParty(CounterpartyRoleEnum party);
		SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder setIsApplicable(Boolean isApplicable);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		}
		

		SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder prune();
	}

	/*********************** Immutable Implementation of SubstitutedRegimeTerms  ***********************/
	class SubstitutedRegimeTermsImpl implements SubstitutedRegimeTerms {
		private final CounterpartyRoleEnum party;
		private final Boolean isApplicable;
		
		protected SubstitutedRegimeTermsImpl(SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder builder) {
			this.party = builder.getParty();
			this.isApplicable = builder.getIsApplicable();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
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
		public SubstitutedRegimeTerms build() {
			return this;
		}
		
		@Override
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder toBuilder() {
			SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutedRegimeTerms _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutedRegimeTerms {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}

	/*********************** Builder Implementation of SubstitutedRegimeTerms  ***********************/
	class SubstitutedRegimeTermsBuilderImpl implements SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean isApplicable;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@Override
		public SubstitutedRegimeTerms build() {
			return new SubstitutedRegimeTerms.SubstitutedRegimeTermsImpl(this);
		}
		
		@Override
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getIsApplicable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder o = (SubstitutedRegimeTerms.SubstitutedRegimeTermsBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SubstitutedRegimeTerms _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutedRegimeTermsBuilder {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}
}
