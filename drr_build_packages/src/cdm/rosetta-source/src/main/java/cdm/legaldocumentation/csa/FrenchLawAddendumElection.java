package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.FrenchLawAddendumElectionMeta;
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
 * A class to specify party specific French Law Addendum language.
 * @version 6.23.0
 */
@RosettaDataType(value="FrenchLawAddendumElection", builder=FrenchLawAddendumElection.FrenchLawAddendumElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FrenchLawAddendumElection", model="cdm", builder=FrenchLawAddendumElection.FrenchLawAddendumElectionBuilderImpl.class, version="6.23.0")
public interface FrenchLawAddendumElection extends RosettaModelObject {

	FrenchLawAddendumElectionMeta metaData = new FrenchLawAddendumElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The qualification of whether the party elects specific language.
	 */
	Boolean getIsApplicable();
	/**
	 * The party specific language to be included in the agreement.
	 */
	String getAddendumLanguage();

	/*********************** Build Methods  ***********************/
	FrenchLawAddendumElection build();
	
	FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder toBuilder();
	
	static FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder builder() {
		return new FrenchLawAddendumElection.FrenchLawAddendumElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FrenchLawAddendumElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FrenchLawAddendumElection> getType() {
		return FrenchLawAddendumElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("addendumLanguage"), String.class, getAddendumLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FrenchLawAddendumElectionBuilder extends FrenchLawAddendumElection, RosettaModelObjectBuilder {
		FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setParty(CounterpartyRoleEnum party);
		FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setIsApplicable(Boolean isApplicable);
		FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setAddendumLanguage(String addendumLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("addendumLanguage"), String.class, getAddendumLanguage(), this);
		}
		

		FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder prune();
	}

	/*********************** Immutable Implementation of FrenchLawAddendumElection  ***********************/
	class FrenchLawAddendumElectionImpl implements FrenchLawAddendumElection {
		private final CounterpartyRoleEnum party;
		private final Boolean isApplicable;
		private final String addendumLanguage;
		
		protected FrenchLawAddendumElectionImpl(FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder builder) {
			this.party = builder.getParty();
			this.isApplicable = builder.getIsApplicable();
			this.addendumLanguage = builder.getAddendumLanguage();
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
		@RosettaAttribute("addendumLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addendumLanguage")
		public String getAddendumLanguage() {
			return addendumLanguage;
		}
		
		@Override
		public FrenchLawAddendumElection build() {
			return this;
		}
		
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder toBuilder() {
			FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getAddendumLanguage()).ifPresent(builder::setAddendumLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FrenchLawAddendumElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(addendumLanguage, _that.getAddendumLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (addendumLanguage != null ? addendumLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FrenchLawAddendumElection {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"addendumLanguage=" + this.addendumLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of FrenchLawAddendumElection  ***********************/
	class FrenchLawAddendumElectionBuilderImpl implements FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean isApplicable;
		protected String addendumLanguage;
		
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
		@RosettaAttribute("addendumLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addendumLanguage")
		public String getAddendumLanguage() {
			return addendumLanguage;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("addendumLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("addendumLanguage")
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder setAddendumLanguage(String _addendumLanguage) {
			this.addendumLanguage = _addendumLanguage == null ? null : _addendumLanguage;
			return this;
		}
		
		@Override
		public FrenchLawAddendumElection build() {
			return new FrenchLawAddendumElection.FrenchLawAddendumElectionImpl(this);
		}
		
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getIsApplicable()!=null) return true;
			if (getAddendumLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder o = (FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getAddendumLanguage(), o.getAddendumLanguage(), this::setAddendumLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FrenchLawAddendumElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(addendumLanguage, _that.getAddendumLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (addendumLanguage != null ? addendumLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FrenchLawAddendumElectionBuilder {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"addendumLanguage=" + this.addendumLanguage +
			'}';
		}
	}
}
