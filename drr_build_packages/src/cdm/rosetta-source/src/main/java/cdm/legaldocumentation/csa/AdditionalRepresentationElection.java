package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.AdditionalRepresentationElectionMeta;
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
 * A class to specify the parties&#39; Additional Representation(s) election.
 * @version 6.23.0
 */
@RosettaDataType(value="AdditionalRepresentationElection", builder=AdditionalRepresentationElection.AdditionalRepresentationElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AdditionalRepresentationElection", model="cdm", builder=AdditionalRepresentationElection.AdditionalRepresentationElectionBuilderImpl.class, version="6.23.0")
public interface AdditionalRepresentationElection extends RosettaModelObject {

	AdditionalRepresentationElectionMeta metaData = new AdditionalRepresentationElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The Additional Representation is applicable when True, and not applicable when False.
	 */
	Boolean getIsApplicable();

	/*********************** Build Methods  ***********************/
	AdditionalRepresentationElection build();
	
	AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder toBuilder();
	
	static AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder builder() {
		return new AdditionalRepresentationElection.AdditionalRepresentationElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdditionalRepresentationElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdditionalRepresentationElection> getType() {
		return AdditionalRepresentationElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdditionalRepresentationElectionBuilder extends AdditionalRepresentationElection, RosettaModelObjectBuilder {
		AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder setParty(CounterpartyRoleEnum party);
		AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder setIsApplicable(Boolean isApplicable);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		}
		

		AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder prune();
	}

	/*********************** Immutable Implementation of AdditionalRepresentationElection  ***********************/
	class AdditionalRepresentationElectionImpl implements AdditionalRepresentationElection {
		private final CounterpartyRoleEnum party;
		private final Boolean isApplicable;
		
		protected AdditionalRepresentationElectionImpl(AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder builder) {
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
		public AdditionalRepresentationElection build() {
			return this;
		}
		
		@Override
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder toBuilder() {
			AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRepresentationElection _that = getType().cast(o);
		
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
			return "AdditionalRepresentationElection {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}

	/*********************** Builder Implementation of AdditionalRepresentationElection  ***********************/
	class AdditionalRepresentationElectionBuilderImpl implements AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder {
	
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
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@Override
		public AdditionalRepresentationElection build() {
			return new AdditionalRepresentationElection.AdditionalRepresentationElectionImpl(this);
		}
		
		@Override
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder prune() {
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
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder o = (AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRepresentationElection _that = getType().cast(o);
		
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
			return "AdditionalRepresentationElectionBuilder {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}
}
