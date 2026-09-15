package fpml.consolidated.asset;

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
import com.rosetta.util.ListEquals;
import fpml.consolidated.asset.meta.GenericSecurityMeta;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Concrete type to support public/private identifiers and classification (ISIN, CFI, ...) for a security of unspecified type. Derived as no-operation extension on IdentifiedAsset (abstract base type)
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Concrete type to support public/private identifiers and classification (ISIN, CFI, ...) for a security of unspecified type. Derived as no-operation extension on IdentifiedAsset (abstract base type)
 *
 */
@RosettaDataType(value="GenericSecurity", builder=GenericSecurity.GenericSecurityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GenericSecurity", model="fpml", builder=GenericSecurity.GenericSecurityBuilderImpl.class, version="2.1.1")
public interface GenericSecurity extends GenericAsset {

	GenericSecurityMeta metaData = new GenericSecurityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Trading currency of the underlyer when transacted as a cash instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Trading currency of the underlyer when transacted as a cash instrument.
	 *
	 */
	IdentifiedCurrency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the issuer name of a fixed income security or convertible bond. The name is specified as an href into one of the party blocks.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the issuer name of a fixed income security or convertible bond. The name is specified as an href into one of the party blocks.
	 *
	 */
	PartyReference getIssuerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Credit quality type (e.g. SFTR specified types: 'INVG' - Investment grade; 'NIVG' - Non-investment grade; 'NOTR' - Non-rated). Classifies the risk of the security. Note: 'NOAP' - Not applicable value is indicated by the absence of the 'creditQuality' element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Credit quality type (e.g. SFTR specified types: 'INVG' - Investment grade; 'NIVG' - Non-investment grade; 'NOTR' - Non-rated). Classifies the risk of the security. Note: 'NOAP' - Not applicable value is indicated by the absence of the 'creditQuality' element.
	 *
	 */
	List<? extends CreditQuality> getCreditQuality();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Credit maturity. The date when the principal amount of a security becomes due and payable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Credit maturity. The date when the principal amount of a security becomes due and payable.
	 *
	 */
	ZonedDateTime getMaturity();

	/*********************** Build Methods  ***********************/
	GenericSecurity build();
	
	GenericSecurity.GenericSecurityBuilder toBuilder();
	
	static GenericSecurity.GenericSecurityBuilder builder() {
		return new GenericSecurity.GenericSecurityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericSecurity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericSecurity> getType() {
		return GenericSecurity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.class, getInstrumentType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.class, getIssuerPartyReference());
		processRosetta(path.newSubPath("creditQuality"), processor, CreditQuality.class, getCreditQuality());
		processor.processBasic(path.newSubPath("maturity"), ZonedDateTime.class, getMaturity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericSecurityBuilder extends GenericSecurity, GenericAsset.GenericAssetBuilder {
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency();
		@Override
		IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency();
		PartyReference.PartyReferenceBuilder getOrCreateIssuerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getIssuerPartyReference();
		CreditQuality.CreditQualityBuilder getOrCreateCreditQuality(int index);
		@Override
		List<? extends CreditQuality.CreditQualityBuilder> getCreditQuality();
		@Override
		GenericSecurity.GenericSecurityBuilder setId(String id);
		@Override
		GenericSecurity.GenericSecurityBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		GenericSecurity.GenericSecurityBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		GenericSecurity.GenericSecurityBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		GenericSecurity.GenericSecurityBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		GenericSecurity.GenericSecurityBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		GenericSecurity.GenericSecurityBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		GenericSecurity.GenericSecurityBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		GenericSecurity.GenericSecurityBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		GenericSecurity.GenericSecurityBuilder setDescription(String description);
		GenericSecurity.GenericSecurityBuilder setCurrency(IdentifiedCurrency currency);
		GenericSecurity.GenericSecurityBuilder setIssuerPartyReference(PartyReference issuerPartyReference);
		GenericSecurity.GenericSecurityBuilder addCreditQuality(CreditQuality creditQuality);
		GenericSecurity.GenericSecurityBuilder addCreditQuality(CreditQuality creditQuality, int idx);
		GenericSecurity.GenericSecurityBuilder addCreditQuality(List<? extends CreditQuality> creditQuality);
		GenericSecurity.GenericSecurityBuilder setCreditQuality(List<? extends CreditQuality> creditQuality);
		GenericSecurity.GenericSecurityBuilder setMaturity(ZonedDateTime maturity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.InstrumentTypeBuilder.class, getInstrumentType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getIssuerPartyReference());
			processRosetta(path.newSubPath("creditQuality"), processor, CreditQuality.CreditQualityBuilder.class, getCreditQuality());
			processor.processBasic(path.newSubPath("maturity"), ZonedDateTime.class, getMaturity(), this);
		}
		

		GenericSecurity.GenericSecurityBuilder prune();
	}

	/*********************** Immutable Implementation of GenericSecurity  ***********************/
	class GenericSecurityImpl extends GenericAsset.GenericAssetImpl implements GenericSecurity {
		private final IdentifiedCurrency currency;
		private final PartyReference issuerPartyReference;
		private final List<? extends CreditQuality> creditQuality;
		private final ZonedDateTime maturity;
		
		protected GenericSecurityImpl(GenericSecurity.GenericSecurityBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.issuerPartyReference = ofNullable(builder.getIssuerPartyReference()).map(f->f.build()).orElse(null);
			this.creditQuality = ofNullable(builder.getCreditQuality()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.maturity = builder.getMaturity();
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public IdentifiedCurrency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuerPartyReference")
		public PartyReference getIssuerPartyReference() {
			return issuerPartyReference;
		}
		
		@Override
		@RosettaAttribute("creditQuality")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditQuality")
		public List<? extends CreditQuality> getCreditQuality() {
			return creditQuality;
		}
		
		@Override
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturity")
		public ZonedDateTime getMaturity() {
			return maturity;
		}
		
		@Override
		public GenericSecurity build() {
			return this;
		}
		
		@Override
		public GenericSecurity.GenericSecurityBuilder toBuilder() {
			GenericSecurity.GenericSecurityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericSecurity.GenericSecurityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getIssuerPartyReference()).ifPresent(builder::setIssuerPartyReference);
			ofNullable(getCreditQuality()).ifPresent(builder::setCreditQuality);
			ofNullable(getMaturity()).ifPresent(builder::setMaturity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericSecurity _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!ListEquals.listEquals(creditQuality, _that.getCreditQuality())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (creditQuality != null ? creditQuality.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericSecurity {" +
				"currency=" + this.currency + ", " +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"creditQuality=" + this.creditQuality + ", " +
				"maturity=" + this.maturity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GenericSecurity  ***********************/
	class GenericSecurityBuilderImpl extends GenericAsset.GenericAssetBuilderImpl implements GenericSecurity.GenericSecurityBuilder {
	
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder currency;
		protected PartyReference.PartyReferenceBuilder issuerPartyReference;
		protected List<CreditQuality.CreditQualityBuilder> creditQuality = new ArrayList<>();
		protected ZonedDateTime maturity;
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuerPartyReference")
		public PartyReference.PartyReferenceBuilder getIssuerPartyReference() {
			return issuerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateIssuerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (issuerPartyReference!=null) {
				result = issuerPartyReference;
			}
			else {
				result = issuerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditQuality")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditQuality")
		public List<? extends CreditQuality.CreditQualityBuilder> getCreditQuality() {
			return creditQuality;
		}
		
		@Override
		public CreditQuality.CreditQualityBuilder getOrCreateCreditQuality(int index) {
			if (creditQuality==null) {
				this.creditQuality = new ArrayList<>();
			}
			return getIndex(creditQuality, index, () -> {
						CreditQuality.CreditQualityBuilder newCreditQuality = CreditQuality.builder();
						return newCreditQuality;
					});
		}
		
		@Override
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturity")
		public ZonedDateTime getMaturity() {
			return maturity;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public GenericSecurity.GenericSecurityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public GenericSecurity.GenericSecurityBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericSecurity.GenericSecurityBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public GenericSecurity.GenericSecurityBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public GenericSecurity.GenericSecurityBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public GenericSecurity.GenericSecurityBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericSecurity.GenericSecurityBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public GenericSecurity.GenericSecurityBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes != null) {
				for (final InstrumentType toAdd : instrumentTypes) {
					this.instrumentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public GenericSecurity.GenericSecurityBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes == null) {
				this.instrumentType = new ArrayList<>();
			} else {
				this.instrumentType = instrumentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public GenericSecurity.GenericSecurityBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public GenericSecurity.GenericSecurityBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuerPartyReference")
		@Override
		public GenericSecurity.GenericSecurityBuilder setIssuerPartyReference(PartyReference _issuerPartyReference) {
			this.issuerPartyReference = _issuerPartyReference == null ? null : _issuerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditQuality")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditQuality")
		@Override
		public GenericSecurity.GenericSecurityBuilder addCreditQuality(CreditQuality _creditQuality) {
			if (_creditQuality != null) {
				this.creditQuality.add(_creditQuality.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericSecurity.GenericSecurityBuilder addCreditQuality(CreditQuality _creditQuality, int idx) {
			getIndex(this.creditQuality, idx, () -> _creditQuality.toBuilder());
			return this;
		}
		
		@Override
		public GenericSecurity.GenericSecurityBuilder addCreditQuality(List<? extends CreditQuality> creditQualitys) {
			if (creditQualitys != null) {
				for (final CreditQuality toAdd : creditQualitys) {
					this.creditQuality.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditQuality")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("creditQuality")
		@Override
		public GenericSecurity.GenericSecurityBuilder setCreditQuality(List<? extends CreditQuality> creditQualitys) {
			if (creditQualitys == null) {
				this.creditQuality = new ArrayList<>();
			} else {
				this.creditQuality = creditQualitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturity")
		@Override
		public GenericSecurity.GenericSecurityBuilder setMaturity(ZonedDateTime _maturity) {
			this.maturity = _maturity == null ? null : _maturity;
			return this;
		}
		
		@Override
		public GenericSecurity build() {
			return new GenericSecurity.GenericSecurityImpl(this);
		}
		
		@Override
		public GenericSecurity.GenericSecurityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericSecurity.GenericSecurityBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (issuerPartyReference!=null && !issuerPartyReference.prune().hasData()) issuerPartyReference = null;
			creditQuality = creditQuality.stream().filter(b->b!=null).<CreditQuality.CreditQualityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getIssuerPartyReference()!=null && getIssuerPartyReference().hasData()) return true;
			if (getCreditQuality()!=null && getCreditQuality().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMaturity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericSecurity.GenericSecurityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			GenericSecurity.GenericSecurityBuilder o = (GenericSecurity.GenericSecurityBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getIssuerPartyReference(), o.getIssuerPartyReference(), this::setIssuerPartyReference);
			merger.mergeRosetta(getCreditQuality(), o.getCreditQuality(), this::getOrCreateCreditQuality);
			
			merger.mergeBasic(getMaturity(), o.getMaturity(), this::setMaturity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericSecurity _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!ListEquals.listEquals(creditQuality, _that.getCreditQuality())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (creditQuality != null ? creditQuality.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericSecurityBuilder {" +
				"currency=" + this.currency + ", " +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"creditQuality=" + this.creditQuality + ", " +
				"maturity=" + this.maturity +
			'}' + " " + super.toString();
		}
	}
}
