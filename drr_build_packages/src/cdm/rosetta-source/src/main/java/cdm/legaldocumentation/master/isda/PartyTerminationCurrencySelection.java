package cdm.legaldocumentation.master.isda;

import cdm.base.staticdata.party.Party;
import cdm.legaldocumentation.master.isda.meta.PartyTerminationCurrencySelectionMeta;
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
 * Specifies the termination currency to be used by a party when it is the Non-Defaulting Party or the Party which is not the Affected Party.
 * @version 6.23.0
 */
@RosettaDataType(value="PartyTerminationCurrencySelection", builder=PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="PartyTerminationCurrencySelection", model="cdm", builder=PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilderImpl.class, version="6.23.0")
public interface PartyTerminationCurrencySelection extends RosettaModelObject {

	PartyTerminationCurrencySelectionMeta metaData = new PartyTerminationCurrencySelectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	Party getParty();
	/**
	 * Specifies termination Currency.
	 */
	String getStatedPartyCurrency();

	/*********************** Build Methods  ***********************/
	PartyTerminationCurrencySelection build();
	
	PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder toBuilder();
	
	static PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder builder() {
		return new PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyTerminationCurrencySelection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyTerminationCurrencySelection> getType() {
		return PartyTerminationCurrencySelection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processor.processBasic(path.newSubPath("statedPartyCurrency"), String.class, getStatedPartyCurrency(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyTerminationCurrencySelectionBuilder extends PartyTerminationCurrencySelection, RosettaModelObjectBuilder {
		Party.PartyBuilder getOrCreateParty();
		@Override
		Party.PartyBuilder getParty();
		PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder setParty(Party party);
		PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder setStatedPartyCurrency(String statedPartyCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processor.processBasic(path.newSubPath("statedPartyCurrency"), String.class, getStatedPartyCurrency(), this);
		}
		

		PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder prune();
	}

	/*********************** Immutable Implementation of PartyTerminationCurrencySelection  ***********************/
	class PartyTerminationCurrencySelectionImpl implements PartyTerminationCurrencySelection {
		private final Party party;
		private final String statedPartyCurrency;
		
		protected PartyTerminationCurrencySelectionImpl(PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder builder) {
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
			this.statedPartyCurrency = builder.getStatedPartyCurrency();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public Party getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("statedPartyCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("statedPartyCurrency")
		public String getStatedPartyCurrency() {
			return statedPartyCurrency;
		}
		
		@Override
		public PartyTerminationCurrencySelection build() {
			return this;
		}
		
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder toBuilder() {
			PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getStatedPartyCurrency()).ifPresent(builder::setStatedPartyCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTerminationCurrencySelection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(statedPartyCurrency, _that.getStatedPartyCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (statedPartyCurrency != null ? statedPartyCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTerminationCurrencySelection {" +
				"party=" + this.party + ", " +
				"statedPartyCurrency=" + this.statedPartyCurrency +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyTerminationCurrencySelection  ***********************/
	class PartyTerminationCurrencySelectionBuilderImpl implements PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder {
	
		protected Party.PartyBuilder party;
		protected String statedPartyCurrency;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public Party.PartyBuilder getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty() {
			Party.PartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = Party.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("statedPartyCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("statedPartyCurrency")
		public String getStatedPartyCurrency() {
			return statedPartyCurrency;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder setParty(Party _party) {
			this.party = _party == null ? null : _party.toBuilder();
			return this;
		}
		
		@RosettaAttribute("statedPartyCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("statedPartyCurrency")
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder setStatedPartyCurrency(String _statedPartyCurrency) {
			this.statedPartyCurrency = _statedPartyCurrency == null ? null : _statedPartyCurrency;
			return this;
		}
		
		@Override
		public PartyTerminationCurrencySelection build() {
			return new PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionImpl(this);
		}
		
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder prune() {
			if (party!=null && !party.prune().hasData()) party = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null && getParty().hasData()) return true;
			if (getStatedPartyCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder o = (PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			
			merger.mergeBasic(getStatedPartyCurrency(), o.getStatedPartyCurrency(), this::setStatedPartyCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTerminationCurrencySelection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(statedPartyCurrency, _that.getStatedPartyCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (statedPartyCurrency != null ? statedPartyCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTerminationCurrencySelectionBuilder {" +
				"party=" + this.party + ", " +
				"statedPartyCurrency=" + this.statedPartyCurrency +
			'}';
		}
	}
}
