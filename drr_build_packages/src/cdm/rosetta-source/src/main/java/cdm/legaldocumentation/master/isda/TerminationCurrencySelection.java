package cdm.legaldocumentation.master.isda;

import cdm.legaldocumentation.master.isda.meta.TerminationCurrencySelectionMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies Termination Currency where a currency is stated at the time the agreement is entered into.
 * @version 6.23.0
 */
@RosettaDataType(value="TerminationCurrencySelection", builder=TerminationCurrencySelection.TerminationCurrencySelectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="TerminationCurrencySelection", model="cdm", builder=TerminationCurrencySelection.TerminationCurrencySelectionBuilderImpl.class, version="6.23.0")
public interface TerminationCurrencySelection extends RosettaModelObject {

	TerminationCurrencySelectionMeta metaData = new TerminationCurrencySelectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies a single Termination Currency for the agreement.
	 */
	String getStatedCurrency();
	/**
	 * Specifies a single fallback Termination Currency should the stated currency not be freely available.
	 */
	String getFallbackCurrency();
	/**
	 * Specifies different termination currencies to apply depending on which party or parties are the Defaulting Party Affected Party(ies).
	 */
	List<? extends PartyTerminationCurrencySelection> getPartyElection();
	/**
	 * Specifies fallback Termination Currency where both parties are Affected Parties.
	 */
	String getBothAffected();

	/*********************** Build Methods  ***********************/
	TerminationCurrencySelection build();
	
	TerminationCurrencySelection.TerminationCurrencySelectionBuilder toBuilder();
	
	static TerminationCurrencySelection.TerminationCurrencySelectionBuilder builder() {
		return new TerminationCurrencySelection.TerminationCurrencySelectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TerminationCurrencySelection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TerminationCurrencySelection> getType() {
		return TerminationCurrencySelection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("statedCurrency"), String.class, getStatedCurrency(), this);
		processor.processBasic(path.newSubPath("fallbackCurrency"), String.class, getFallbackCurrency(), this);
		processRosetta(path.newSubPath("partyElection"), processor, PartyTerminationCurrencySelection.class, getPartyElection());
		processor.processBasic(path.newSubPath("bothAffected"), String.class, getBothAffected(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TerminationCurrencySelectionBuilder extends TerminationCurrencySelection, RosettaModelObjectBuilder {
		PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder> getPartyElection();
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder setStatedCurrency(String statedCurrency);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder setFallbackCurrency(String fallbackCurrency);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(PartyTerminationCurrencySelection partyElection);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(PartyTerminationCurrencySelection partyElection, int idx);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(List<? extends PartyTerminationCurrencySelection> partyElection);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder setPartyElection(List<? extends PartyTerminationCurrencySelection> partyElection);
		TerminationCurrencySelection.TerminationCurrencySelectionBuilder setBothAffected(String bothAffected);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("statedCurrency"), String.class, getStatedCurrency(), this);
			processor.processBasic(path.newSubPath("fallbackCurrency"), String.class, getFallbackCurrency(), this);
			processRosetta(path.newSubPath("partyElection"), processor, PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder.class, getPartyElection());
			processor.processBasic(path.newSubPath("bothAffected"), String.class, getBothAffected(), this);
		}
		

		TerminationCurrencySelection.TerminationCurrencySelectionBuilder prune();
	}

	/*********************** Immutable Implementation of TerminationCurrencySelection  ***********************/
	class TerminationCurrencySelectionImpl implements TerminationCurrencySelection {
		private final String statedCurrency;
		private final String fallbackCurrency;
		private final List<? extends PartyTerminationCurrencySelection> partyElection;
		private final String bothAffected;
		
		protected TerminationCurrencySelectionImpl(TerminationCurrencySelection.TerminationCurrencySelectionBuilder builder) {
			this.statedCurrency = builder.getStatedCurrency();
			this.fallbackCurrency = builder.getFallbackCurrency();
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.bothAffected = builder.getBothAffected();
		}
		
		@Override
		@RosettaAttribute("statedCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("statedCurrency")
		public String getStatedCurrency() {
			return statedCurrency;
		}
		
		@Override
		@RosettaAttribute("fallbackCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackCurrency")
		public String getFallbackCurrency() {
			return fallbackCurrency;
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends PartyTerminationCurrencySelection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		@RosettaAttribute("bothAffected")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bothAffected")
		public String getBothAffected() {
			return bothAffected;
		}
		
		@Override
		public TerminationCurrencySelection build() {
			return this;
		}
		
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder toBuilder() {
			TerminationCurrencySelection.TerminationCurrencySelectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TerminationCurrencySelection.TerminationCurrencySelectionBuilder builder) {
			ofNullable(getStatedCurrency()).ifPresent(builder::setStatedCurrency);
			ofNullable(getFallbackCurrency()).ifPresent(builder::setFallbackCurrency);
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
			ofNullable(getBothAffected()).ifPresent(builder::setBothAffected);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencySelection _that = getType().cast(o);
		
			if (!Objects.equals(statedCurrency, _that.getStatedCurrency())) return false;
			if (!Objects.equals(fallbackCurrency, _that.getFallbackCurrency())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!Objects.equals(bothAffected, _that.getBothAffected())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (statedCurrency != null ? statedCurrency.hashCode() : 0);
			_result = 31 * _result + (fallbackCurrency != null ? fallbackCurrency.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (bothAffected != null ? bothAffected.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencySelection {" +
				"statedCurrency=" + this.statedCurrency + ", " +
				"fallbackCurrency=" + this.fallbackCurrency + ", " +
				"partyElection=" + this.partyElection + ", " +
				"bothAffected=" + this.bothAffected +
			'}';
		}
	}

	/*********************** Builder Implementation of TerminationCurrencySelection  ***********************/
	class TerminationCurrencySelectionBuilderImpl implements TerminationCurrencySelection.TerminationCurrencySelectionBuilder {
	
		protected String statedCurrency;
		protected String fallbackCurrency;
		protected List<PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder> partyElection = new ArrayList<>();
		protected String bothAffected;
		
		@Override
		@RosettaAttribute("statedCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("statedCurrency")
		public String getStatedCurrency() {
			return statedCurrency;
		}
		
		@Override
		@RosettaAttribute("fallbackCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackCurrency")
		public String getFallbackCurrency() {
			return fallbackCurrency;
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder newPartyElection = PartyTerminationCurrencySelection.builder();
						return newPartyElection;
					});
		}
		
		@Override
		@RosettaAttribute("bothAffected")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bothAffected")
		public String getBothAffected() {
			return bothAffected;
		}
		
		@RosettaAttribute("statedCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("statedCurrency")
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder setStatedCurrency(String _statedCurrency) {
			this.statedCurrency = _statedCurrency == null ? null : _statedCurrency;
			return this;
		}
		
		@RosettaAttribute("fallbackCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackCurrency")
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder setFallbackCurrency(String _fallbackCurrency) {
			this.fallbackCurrency = _fallbackCurrency == null ? null : _fallbackCurrency;
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(PartyTerminationCurrencySelection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(PartyTerminationCurrencySelection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder addPartyElection(List<? extends PartyTerminationCurrencySelection> partyElections) {
			if (partyElections != null) {
				for (final PartyTerminationCurrencySelection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder setPartyElection(List<? extends PartyTerminationCurrencySelection> partyElections) {
			if (partyElections == null) {
				this.partyElection = new ArrayList<>();
			} else {
				this.partyElection = partyElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("bothAffected")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bothAffected")
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder setBothAffected(String _bothAffected) {
			this.bothAffected = _bothAffected == null ? null : _bothAffected;
			return this;
		}
		
		@Override
		public TerminationCurrencySelection build() {
			return new TerminationCurrencySelection.TerminationCurrencySelectionImpl(this);
		}
		
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<PartyTerminationCurrencySelection.PartyTerminationCurrencySelectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStatedCurrency()!=null) return true;
			if (getFallbackCurrency()!=null) return true;
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBothAffected()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencySelection.TerminationCurrencySelectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TerminationCurrencySelection.TerminationCurrencySelectionBuilder o = (TerminationCurrencySelection.TerminationCurrencySelectionBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getStatedCurrency(), o.getStatedCurrency(), this::setStatedCurrency);
			merger.mergeBasic(getFallbackCurrency(), o.getFallbackCurrency(), this::setFallbackCurrency);
			merger.mergeBasic(getBothAffected(), o.getBothAffected(), this::setBothAffected);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencySelection _that = getType().cast(o);
		
			if (!Objects.equals(statedCurrency, _that.getStatedCurrency())) return false;
			if (!Objects.equals(fallbackCurrency, _that.getFallbackCurrency())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!Objects.equals(bothAffected, _that.getBothAffected())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (statedCurrency != null ? statedCurrency.hashCode() : 0);
			_result = 31 * _result + (fallbackCurrency != null ? fallbackCurrency.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (bothAffected != null ? bothAffected.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencySelectionBuilder {" +
				"statedCurrency=" + this.statedCurrency + ", " +
				"fallbackCurrency=" + this.fallbackCurrency + ", " +
				"partyElection=" + this.partyElection + ", " +
				"bothAffected=" + this.bothAffected +
			'}';
		}
	}
}
