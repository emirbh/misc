package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.SecurityMeta;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Identifies a security of implicit type (derivable from the security reference data).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Identifies a security of implicit type (derivable from the security reference data).
 *
 */
@RosettaDataType(value="Security", builder=Security.SecurityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Security", model="fpml", builder=Security.SecurityBuilderImpl.class, version="2.1.1")
public interface Security extends GenericSecurity {

	SecurityMeta metaData = new SecurityMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Security build();
	
	Security.SecurityBuilder toBuilder();
	
	static Security.SecurityBuilder builder() {
		return new Security.SecurityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Security> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Security> getType() {
		return Security.class;
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
	interface SecurityBuilder extends Security, GenericSecurity.GenericSecurityBuilder {
		@Override
		Security.SecurityBuilder setId(String id);
		@Override
		Security.SecurityBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		Security.SecurityBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		Security.SecurityBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Security.SecurityBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Security.SecurityBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		Security.SecurityBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		Security.SecurityBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Security.SecurityBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Security.SecurityBuilder setDescription(String description);
		@Override
		Security.SecurityBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		Security.SecurityBuilder setIssuerPartyReference(PartyReference issuerPartyReference);
		@Override
		Security.SecurityBuilder addCreditQuality(CreditQuality creditQuality);
		@Override
		Security.SecurityBuilder addCreditQuality(CreditQuality creditQuality, int idx);
		@Override
		Security.SecurityBuilder addCreditQuality(List<? extends CreditQuality> creditQuality);
		@Override
		Security.SecurityBuilder setCreditQuality(List<? extends CreditQuality> creditQuality);
		@Override
		Security.SecurityBuilder setMaturity(ZonedDateTime maturity);

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
		

		Security.SecurityBuilder prune();
	}

	/*********************** Immutable Implementation of Security  ***********************/
	class SecurityImpl extends GenericSecurity.GenericSecurityImpl implements Security {
		
		protected SecurityImpl(Security.SecurityBuilder builder) {
			super(builder);
		}
		
		@Override
		public Security build() {
			return this;
		}
		
		@Override
		public Security.SecurityBuilder toBuilder() {
			Security.SecurityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Security.SecurityBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Security {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Security  ***********************/
	class SecurityBuilderImpl extends GenericSecurity.GenericSecurityBuilderImpl implements Security.SecurityBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Security.SecurityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Security.SecurityBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Security.SecurityBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Security.SecurityBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public Security.SecurityBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public Security.SecurityBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public Security.SecurityBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuerPartyReference")
		@Override
		public Security.SecurityBuilder setIssuerPartyReference(PartyReference _issuerPartyReference) {
			this.issuerPartyReference = _issuerPartyReference == null ? null : _issuerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditQuality")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditQuality")
		@Override
		public Security.SecurityBuilder addCreditQuality(CreditQuality _creditQuality) {
			if (_creditQuality != null) {
				this.creditQuality.add(_creditQuality.toBuilder());
			}
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addCreditQuality(CreditQuality _creditQuality, int idx) {
			getIndex(this.creditQuality, idx, () -> _creditQuality.toBuilder());
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addCreditQuality(List<? extends CreditQuality> creditQualitys) {
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
		public Security.SecurityBuilder setCreditQuality(List<? extends CreditQuality> creditQualitys) {
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
		public Security.SecurityBuilder setMaturity(ZonedDateTime _maturity) {
			this.maturity = _maturity == null ? null : _maturity;
			return this;
		}
		
		@Override
		public Security build() {
			return new Security.SecurityImpl(this);
		}
		
		@Override
		public Security.SecurityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Security.SecurityBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Security.SecurityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Security.SecurityBuilder o = (Security.SecurityBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
