package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.EligibilityToHoldCollateralMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the conditions under which a party and its custodian(s) are entitled to hold collateral.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
 * paragraph "13" * clause " (h)(i)" * name "Eligibility to Hold Posted Collateral (VM) Custodians (VM)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="EligibilityToHoldCollateral", builder=EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilderImpl.class, version="6.23.0")
@RuneDataType(value="EligibilityToHoldCollateral", model="cdm", builder=EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilderImpl.class, version="6.23.0")
public interface EligibilityToHoldCollateral extends RosettaModelObject {

	EligibilityToHoldCollateralMeta metaData = new EligibilityToHoldCollateralMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The condition(s) required by a party from the other party to hold its posted collateral.
	 */
	List<HoldingPostedCollateralEnum> getPartyTerms();
	/**
	 * The restrictions that might be required by a party from the other party&#39;s custodian agent to hold its posted collateral.
	 */
	CustodianTerms getCustodianTerms();
	/**
	 * The restrictions that might be required by a party from the other party in terms of country(ies) where collateral can be held.
	 */
	List<? extends FieldWithMetaString> getEligibleCountry();

	/*********************** Build Methods  ***********************/
	EligibilityToHoldCollateral build();
	
	EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder toBuilder();
	
	static EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder builder() {
		return new EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EligibilityToHoldCollateral> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EligibilityToHoldCollateral> getType() {
		return EligibilityToHoldCollateral.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("partyTerms"), HoldingPostedCollateralEnum.class, getPartyTerms(), this);
		processRosetta(path.newSubPath("custodianTerms"), processor, CustodianTerms.class, getCustodianTerms());
		processRosetta(path.newSubPath("eligibleCountry"), processor, FieldWithMetaString.class, getEligibleCountry());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EligibilityToHoldCollateralBuilder extends EligibilityToHoldCollateral, RosettaModelObjectBuilder {
		CustodianTerms.CustodianTermsBuilder getOrCreateCustodianTerms();
		@Override
		CustodianTerms.CustodianTermsBuilder getCustodianTerms();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateEligibleCountry(int index);
		@Override
		List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getEligibleCountry();
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(HoldingPostedCollateralEnum partyTerms);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(HoldingPostedCollateralEnum partyTerms, int idx);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(List<HoldingPostedCollateralEnum> partyTerms);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setPartyTerms(List<HoldingPostedCollateralEnum> partyTerms);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setCustodianTerms(CustodianTerms custodianTerms);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(FieldWithMetaString eligibleCountry);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(FieldWithMetaString eligibleCountry, int idx);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(String eligibleCountry);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(String eligibleCountry, int idx);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(List<? extends FieldWithMetaString> eligibleCountry);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setEligibleCountry(List<? extends FieldWithMetaString> eligibleCountry);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(List<? extends String> eligibleCountry);
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setEligibleCountryValue(List<? extends String> eligibleCountry);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("partyTerms"), HoldingPostedCollateralEnum.class, getPartyTerms(), this);
			processRosetta(path.newSubPath("custodianTerms"), processor, CustodianTerms.CustodianTermsBuilder.class, getCustodianTerms());
			processRosetta(path.newSubPath("eligibleCountry"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getEligibleCountry());
		}
		

		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder prune();
	}

	/*********************** Immutable Implementation of EligibilityToHoldCollateral  ***********************/
	class EligibilityToHoldCollateralImpl implements EligibilityToHoldCollateral {
		private final List<HoldingPostedCollateralEnum> partyTerms;
		private final CustodianTerms custodianTerms;
		private final List<? extends FieldWithMetaString> eligibleCountry;
		
		protected EligibilityToHoldCollateralImpl(EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder builder) {
			this.partyTerms = ofNullable(builder.getPartyTerms()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.custodianTerms = ofNullable(builder.getCustodianTerms()).map(f->f.build()).orElse(null);
			this.eligibleCountry = ofNullable(builder.getEligibleCountry()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyTerms")
		public List<HoldingPostedCollateralEnum> getPartyTerms() {
			return partyTerms;
		}
		
		@Override
		@RosettaAttribute("custodianTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("custodianTerms")
		public CustodianTerms getCustodianTerms() {
			return custodianTerms;
		}
		
		@Override
		@RosettaAttribute("eligibleCountry")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eligibleCountry")
		public List<? extends FieldWithMetaString> getEligibleCountry() {
			return eligibleCountry;
		}
		
		@Override
		public EligibilityToHoldCollateral build() {
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder toBuilder() {
			EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder builder) {
			ofNullable(getPartyTerms()).ifPresent(builder::setPartyTerms);
			ofNullable(getCustodianTerms()).ifPresent(builder::setCustodianTerms);
			ofNullable(getEligibleCountry()).ifPresent(builder::setEligibleCountry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibilityToHoldCollateral _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTerms, _that.getPartyTerms())) return false;
			if (!Objects.equals(custodianTerms, _that.getCustodianTerms())) return false;
			if (!ListEquals.listEquals(eligibleCountry, _that.getEligibleCountry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTerms != null ? partyTerms.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (custodianTerms != null ? custodianTerms.hashCode() : 0);
			_result = 31 * _result + (eligibleCountry != null ? eligibleCountry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibilityToHoldCollateral {" +
				"partyTerms=" + this.partyTerms + ", " +
				"custodianTerms=" + this.custodianTerms + ", " +
				"eligibleCountry=" + this.eligibleCountry +
			'}';
		}
	}

	/*********************** Builder Implementation of EligibilityToHoldCollateral  ***********************/
	class EligibilityToHoldCollateralBuilderImpl implements EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder {
	
		protected List<HoldingPostedCollateralEnum> partyTerms = new ArrayList<>();
		protected CustodianTerms.CustodianTermsBuilder custodianTerms;
		protected List<FieldWithMetaString.FieldWithMetaStringBuilder> eligibleCountry = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyTerms")
		public List<HoldingPostedCollateralEnum> getPartyTerms() {
			return partyTerms;
		}
		
		@Override
		@RosettaAttribute("custodianTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("custodianTerms")
		public CustodianTerms.CustodianTermsBuilder getCustodianTerms() {
			return custodianTerms;
		}
		
		@Override
		public CustodianTerms.CustodianTermsBuilder getOrCreateCustodianTerms() {
			CustodianTerms.CustodianTermsBuilder result;
			if (custodianTerms!=null) {
				result = custodianTerms;
			}
			else {
				result = custodianTerms = CustodianTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eligibleCountry")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eligibleCountry")
		public List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getEligibleCountry() {
			return eligibleCountry;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateEligibleCountry(int index) {
			if (eligibleCountry==null) {
				this.eligibleCountry = new ArrayList<>();
			}
			return getIndex(eligibleCountry, index, () -> {
						FieldWithMetaString.FieldWithMetaStringBuilder newEligibleCountry = FieldWithMetaString.builder();
						return newEligibleCountry;
					});
		}
		
		@RosettaAttribute("partyTerms")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyTerms")
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(HoldingPostedCollateralEnum _partyTerms) {
			if (_partyTerms != null) {
				this.partyTerms.add(_partyTerms);
			}
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(HoldingPostedCollateralEnum _partyTerms, int idx) {
			getIndex(this.partyTerms, idx, () -> _partyTerms);
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addPartyTerms(List<HoldingPostedCollateralEnum> partyTermss) {
			if (partyTermss != null) {
				for (final HoldingPostedCollateralEnum toAdd : partyTermss) {
					this.partyTerms.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyTerms")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("partyTerms")
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setPartyTerms(List<HoldingPostedCollateralEnum> partyTermss) {
			if (partyTermss == null) {
				this.partyTerms = new ArrayList<>();
			} else {
				this.partyTerms = partyTermss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("custodianTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("custodianTerms")
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setCustodianTerms(CustodianTerms _custodianTerms) {
			this.custodianTerms = _custodianTerms == null ? null : _custodianTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eligibleCountry")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eligibleCountry")
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(FieldWithMetaString _eligibleCountry) {
			if (_eligibleCountry != null) {
				this.eligibleCountry.add(_eligibleCountry.toBuilder());
			}
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(FieldWithMetaString _eligibleCountry, int idx) {
			getIndex(this.eligibleCountry, idx, () -> _eligibleCountry.toBuilder());
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(String _eligibleCountry) {
			this.getOrCreateEligibleCountry(-1).setValue(_eligibleCountry);
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(String _eligibleCountry, int idx) {
			this.getOrCreateEligibleCountry(idx).setValue(_eligibleCountry);
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountry(List<? extends FieldWithMetaString> eligibleCountrys) {
			if (eligibleCountrys != null) {
				for (final FieldWithMetaString toAdd : eligibleCountrys) {
					this.eligibleCountry.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eligibleCountry")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eligibleCountry")
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setEligibleCountry(List<? extends FieldWithMetaString> eligibleCountrys) {
			if (eligibleCountrys == null) {
				this.eligibleCountry = new ArrayList<>();
			} else {
				this.eligibleCountry = eligibleCountrys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder addEligibleCountryValue(List<? extends String> eligibleCountrys) {
			if (eligibleCountrys != null) {
				for (final String toAdd : eligibleCountrys) {
					this.addEligibleCountryValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder setEligibleCountryValue(List<? extends String> eligibleCountrys) {
			this.eligibleCountry.clear();
			if (eligibleCountrys != null) {
				eligibleCountrys.forEach(this::addEligibleCountryValue);
			}
			return this;
		}
		
		@Override
		public EligibilityToHoldCollateral build() {
			return new EligibilityToHoldCollateral.EligibilityToHoldCollateralImpl(this);
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder prune() {
			if (custodianTerms!=null && !custodianTerms.prune().hasData()) custodianTerms = null;
			eligibleCountry = eligibleCountry.stream().filter(b->b!=null).<FieldWithMetaString.FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyTerms()!=null && !getPartyTerms().isEmpty()) return true;
			if (getCustodianTerms()!=null && getCustodianTerms().hasData()) return true;
			if (getEligibleCountry()!=null && !getEligibleCountry().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder o = (EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder) other;
			
			merger.mergeRosetta(getCustodianTerms(), o.getCustodianTerms(), this::setCustodianTerms);
			merger.mergeRosetta(getEligibleCountry(), o.getEligibleCountry(), this::getOrCreateEligibleCountry);
			
			merger.mergeBasic(getPartyTerms(), o.getPartyTerms(), (Consumer<HoldingPostedCollateralEnum>) this::addPartyTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibilityToHoldCollateral _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTerms, _that.getPartyTerms())) return false;
			if (!Objects.equals(custodianTerms, _that.getCustodianTerms())) return false;
			if (!ListEquals.listEquals(eligibleCountry, _that.getEligibleCountry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTerms != null ? partyTerms.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (custodianTerms != null ? custodianTerms.hashCode() : 0);
			_result = 31 * _result + (eligibleCountry != null ? eligibleCountry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibilityToHoldCollateralBuilder {" +
				"partyTerms=" + this.partyTerms + ", " +
				"custodianTerms=" + this.custodianTerms + ", " +
				"eligibleCountry=" + this.eligibleCountry +
			'}';
		}
	}
}
