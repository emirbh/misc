package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.AdditionalObligationsMeta;
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
 * The election of party specific additional obligations applicable to the agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="AdditionalObligations", builder=AdditionalObligations.AdditionalObligationsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AdditionalObligations", model="cdm", builder=AdditionalObligations.AdditionalObligationsBuilderImpl.class, version="6.23.0")
public interface AdditionalObligations extends RosettaModelObject {

	AdditionalObligationsMeta metaData = new AdditionalObligationsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party that the additional obligations apply to.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The party specific additional obligations applicable to the agreement.
	 */
	String getAdditionalObligations();

	/*********************** Build Methods  ***********************/
	AdditionalObligations build();
	
	AdditionalObligations.AdditionalObligationsBuilder toBuilder();
	
	static AdditionalObligations.AdditionalObligationsBuilder builder() {
		return new AdditionalObligations.AdditionalObligationsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdditionalObligations> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdditionalObligations> getType() {
		return AdditionalObligations.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("additionalObligations"), String.class, getAdditionalObligations(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdditionalObligationsBuilder extends AdditionalObligations, RosettaModelObjectBuilder {
		AdditionalObligations.AdditionalObligationsBuilder setParty(CounterpartyRoleEnum party);
		AdditionalObligations.AdditionalObligationsBuilder setAdditionalObligations(String additionalObligations);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("additionalObligations"), String.class, getAdditionalObligations(), this);
		}
		

		AdditionalObligations.AdditionalObligationsBuilder prune();
	}

	/*********************** Immutable Implementation of AdditionalObligations  ***********************/
	class AdditionalObligationsImpl implements AdditionalObligations {
		private final CounterpartyRoleEnum party;
		private final String additionalObligations;
		
		protected AdditionalObligationsImpl(AdditionalObligations.AdditionalObligationsBuilder builder) {
			this.party = builder.getParty();
			this.additionalObligations = builder.getAdditionalObligations();
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
		@RosettaAttribute("additionalObligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("additionalObligations")
		public String getAdditionalObligations() {
			return additionalObligations;
		}
		
		@Override
		public AdditionalObligations build() {
			return this;
		}
		
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder toBuilder() {
			AdditionalObligations.AdditionalObligationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalObligations.AdditionalObligationsBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAdditionalObligations()).ifPresent(builder::setAdditionalObligations);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalObligations _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(additionalObligations, _that.getAdditionalObligations())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalObligations {" +
				"party=" + this.party + ", " +
				"additionalObligations=" + this.additionalObligations +
			'}';
		}
	}

	/*********************** Builder Implementation of AdditionalObligations  ***********************/
	class AdditionalObligationsBuilderImpl implements AdditionalObligations.AdditionalObligationsBuilder {
	
		protected CounterpartyRoleEnum party;
		protected String additionalObligations;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("additionalObligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("additionalObligations")
		public String getAdditionalObligations() {
			return additionalObligations;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("additionalObligations")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("additionalObligations")
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder setAdditionalObligations(String _additionalObligations) {
			this.additionalObligations = _additionalObligations == null ? null : _additionalObligations;
			return this;
		}
		
		@Override
		public AdditionalObligations build() {
			return new AdditionalObligations.AdditionalObligationsImpl(this);
		}
		
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getAdditionalObligations()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalObligations.AdditionalObligationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalObligations.AdditionalObligationsBuilder o = (AdditionalObligations.AdditionalObligationsBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getAdditionalObligations(), o.getAdditionalObligations(), this::setAdditionalObligations);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalObligations _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(additionalObligations, _that.getAdditionalObligations())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalObligationsBuilder {" +
				"party=" + this.party + ", " +
				"additionalObligations=" + this.additionalObligations +
			'}';
		}
	}
}
