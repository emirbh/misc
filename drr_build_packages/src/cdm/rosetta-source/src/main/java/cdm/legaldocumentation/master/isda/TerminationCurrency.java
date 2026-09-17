package cdm.legaldocumentation.master.isda;

import cdm.legaldocumentation.master.isda.meta.TerminationCurrencyMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
 * Specifies how the Termination Currency for the agreement will be determined.
 * @version 6.23.0
 */
@RosettaDataType(value="TerminationCurrency", builder=TerminationCurrency.TerminationCurrencyBuilderImpl.class, version="6.23.0")
@RuneDataType(value="TerminationCurrency", model="cdm", builder=TerminationCurrency.TerminationCurrencyBuilderImpl.class, version="6.23.0")
public interface TerminationCurrency extends RosettaModelObject {

	TerminationCurrencyMeta metaData = new TerminationCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Allows for specific Termination Currency(ies) and a fallback Termination Currency to be selected.
	 */
	TerminationCurrencySelection getStatedTerminationCurrency();
	/**
	 * Provides that the Termination Currency will be determined by reference to a contractual mechanism when closing out the Agreement.
	 */
	PartyOptionTerminationCurrency getPartyOptionTerminationCurrency();

	/*********************** Build Methods  ***********************/
	TerminationCurrency build();
	
	TerminationCurrency.TerminationCurrencyBuilder toBuilder();
	
	static TerminationCurrency.TerminationCurrencyBuilder builder() {
		return new TerminationCurrency.TerminationCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TerminationCurrency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TerminationCurrency> getType() {
		return TerminationCurrency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("statedTerminationCurrency"), processor, TerminationCurrencySelection.class, getStatedTerminationCurrency());
		processRosetta(path.newSubPath("partyOptionTerminationCurrency"), processor, PartyOptionTerminationCurrency.class, getPartyOptionTerminationCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TerminationCurrencyBuilder extends TerminationCurrency, RosettaModelObjectBuilder {
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder getOrCreateStatedTerminationCurrency();
		@Override
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder getStatedTerminationCurrency();
		PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder getOrCreatePartyOptionTerminationCurrency();
		@Override
		PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder getPartyOptionTerminationCurrency();
		TerminationCurrency.TerminationCurrencyBuilder setStatedTerminationCurrency(TerminationCurrencySelection statedTerminationCurrency);
		TerminationCurrency.TerminationCurrencyBuilder setPartyOptionTerminationCurrency(PartyOptionTerminationCurrency partyOptionTerminationCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("statedTerminationCurrency"), processor, TerminationCurrencySelection.TerminationCurrencySelectionBuilder.class, getStatedTerminationCurrency());
			processRosetta(path.newSubPath("partyOptionTerminationCurrency"), processor, PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder.class, getPartyOptionTerminationCurrency());
		}
		

		TerminationCurrency.TerminationCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of TerminationCurrency  ***********************/
	class TerminationCurrencyImpl implements TerminationCurrency {
		private final TerminationCurrencySelection statedTerminationCurrency;
		private final PartyOptionTerminationCurrency partyOptionTerminationCurrency;
		
		protected TerminationCurrencyImpl(TerminationCurrency.TerminationCurrencyBuilder builder) {
			this.statedTerminationCurrency = ofNullable(builder.getStatedTerminationCurrency()).map(f->f.build()).orElse(null);
			this.partyOptionTerminationCurrency = ofNullable(builder.getPartyOptionTerminationCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("statedTerminationCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("statedTerminationCurrency")
		public TerminationCurrencySelection getStatedTerminationCurrency() {
			return statedTerminationCurrency;
		}
		
		@Override
		@RosettaAttribute("partyOptionTerminationCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyOptionTerminationCurrency")
		public PartyOptionTerminationCurrency getPartyOptionTerminationCurrency() {
			return partyOptionTerminationCurrency;
		}
		
		@Override
		public TerminationCurrency build() {
			return this;
		}
		
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder toBuilder() {
			TerminationCurrency.TerminationCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TerminationCurrency.TerminationCurrencyBuilder builder) {
			ofNullable(getStatedTerminationCurrency()).ifPresent(builder::setStatedTerminationCurrency);
			ofNullable(getPartyOptionTerminationCurrency()).ifPresent(builder::setPartyOptionTerminationCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrency _that = getType().cast(o);
		
			if (!Objects.equals(statedTerminationCurrency, _that.getStatedTerminationCurrency())) return false;
			if (!Objects.equals(partyOptionTerminationCurrency, _that.getPartyOptionTerminationCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (statedTerminationCurrency != null ? statedTerminationCurrency.hashCode() : 0);
			_result = 31 * _result + (partyOptionTerminationCurrency != null ? partyOptionTerminationCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrency {" +
				"statedTerminationCurrency=" + this.statedTerminationCurrency + ", " +
				"partyOptionTerminationCurrency=" + this.partyOptionTerminationCurrency +
			'}';
		}
	}

	/*********************** Builder Implementation of TerminationCurrency  ***********************/
	class TerminationCurrencyBuilderImpl implements TerminationCurrency.TerminationCurrencyBuilder {
	
		protected TerminationCurrencySelection.TerminationCurrencySelectionBuilder statedTerminationCurrency;
		protected PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder partyOptionTerminationCurrency;
		
		@Override
		@RosettaAttribute("statedTerminationCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("statedTerminationCurrency")
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder getStatedTerminationCurrency() {
			return statedTerminationCurrency;
		}
		
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder getOrCreateStatedTerminationCurrency() {
			TerminationCurrencySelection.TerminationCurrencySelectionBuilder result;
			if (statedTerminationCurrency!=null) {
				result = statedTerminationCurrency;
			}
			else {
				result = statedTerminationCurrency = TerminationCurrencySelection.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyOptionTerminationCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyOptionTerminationCurrency")
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder getPartyOptionTerminationCurrency() {
			return partyOptionTerminationCurrency;
		}
		
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder getOrCreatePartyOptionTerminationCurrency() {
			PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder result;
			if (partyOptionTerminationCurrency!=null) {
				result = partyOptionTerminationCurrency;
			}
			else {
				result = partyOptionTerminationCurrency = PartyOptionTerminationCurrency.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("statedTerminationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("statedTerminationCurrency")
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder setStatedTerminationCurrency(TerminationCurrencySelection _statedTerminationCurrency) {
			this.statedTerminationCurrency = _statedTerminationCurrency == null ? null : _statedTerminationCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyOptionTerminationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyOptionTerminationCurrency")
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder setPartyOptionTerminationCurrency(PartyOptionTerminationCurrency _partyOptionTerminationCurrency) {
			this.partyOptionTerminationCurrency = _partyOptionTerminationCurrency == null ? null : _partyOptionTerminationCurrency.toBuilder();
			return this;
		}
		
		@Override
		public TerminationCurrency build() {
			return new TerminationCurrency.TerminationCurrencyImpl(this);
		}
		
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder prune() {
			if (statedTerminationCurrency!=null && !statedTerminationCurrency.prune().hasData()) statedTerminationCurrency = null;
			if (partyOptionTerminationCurrency!=null && !partyOptionTerminationCurrency.prune().hasData()) partyOptionTerminationCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStatedTerminationCurrency()!=null && getStatedTerminationCurrency().hasData()) return true;
			if (getPartyOptionTerminationCurrency()!=null && getPartyOptionTerminationCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TerminationCurrency.TerminationCurrencyBuilder o = (TerminationCurrency.TerminationCurrencyBuilder) other;
			
			merger.mergeRosetta(getStatedTerminationCurrency(), o.getStatedTerminationCurrency(), this::setStatedTerminationCurrency);
			merger.mergeRosetta(getPartyOptionTerminationCurrency(), o.getPartyOptionTerminationCurrency(), this::setPartyOptionTerminationCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrency _that = getType().cast(o);
		
			if (!Objects.equals(statedTerminationCurrency, _that.getStatedTerminationCurrency())) return false;
			if (!Objects.equals(partyOptionTerminationCurrency, _that.getPartyOptionTerminationCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (statedTerminationCurrency != null ? statedTerminationCurrency.hashCode() : 0);
			_result = 31 * _result + (partyOptionTerminationCurrency != null ? partyOptionTerminationCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencyBuilder {" +
				"statedTerminationCurrency=" + this.statedTerminationCurrency + ", " +
				"partyOptionTerminationCurrency=" + this.partyOptionTerminationCurrency +
			'}';
		}
	}
}
