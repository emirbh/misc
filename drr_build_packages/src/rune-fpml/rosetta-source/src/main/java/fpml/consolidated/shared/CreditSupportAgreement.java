package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.CreditSupportAgreementMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The agreement executed between the parties and intended to govern collateral arrangement for all OTC derivatives transactions between those parties.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The agreement executed between the parties and intended to govern collateral arrangement for all OTC derivatives transactions between those parties.
 *
 */
@RosettaDataType(value="CreditSupportAgreement", builder=CreditSupportAgreement.CreditSupportAgreementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditSupportAgreement", model="fpml", builder=CreditSupportAgreement.CreditSupportAgreementBuilderImpl.class, version="2.1.1")
public interface CreditSupportAgreement extends RosettaModelObject {

	CreditSupportAgreementMeta metaData = new CreditSupportAgreementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of ISDA Credit Support Agreement
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of ISDA Credit Support Agreement
	 *
	 */
	CreditSupportAgreementType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date of the agreement executed between the parties and intended to govern collateral arrangements for all OTC derivatives transactions between those parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date of the agreement executed between the parties and intended to govern collateral arrangements for all OTC derivatives transactions between those parties.
	 *
	 */
	ZonedDateTime getDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An identifier used to uniquely identify the CSA
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An identifier used to uniquely identify the CSA
	 *
	 */
	CreditSupportAgreementIdentifier getIdentifier();

	/*********************** Build Methods  ***********************/
	CreditSupportAgreement build();
	
	CreditSupportAgreement.CreditSupportAgreementBuilder toBuilder();
	
	static CreditSupportAgreement.CreditSupportAgreementBuilder builder() {
		return new CreditSupportAgreement.CreditSupportAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportAgreement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditSupportAgreement> getType() {
		return CreditSupportAgreement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, CreditSupportAgreementType.class, _getType());
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		processRosetta(path.newSubPath("identifier"), processor, CreditSupportAgreementIdentifier.class, getIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportAgreementBuilder extends CreditSupportAgreement, RosettaModelObjectBuilder {
		CreditSupportAgreementType.CreditSupportAgreementTypeBuilder getOrCreateType();
		@Override
		CreditSupportAgreementType.CreditSupportAgreementTypeBuilder _getType();
		CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder getOrCreateIdentifier();
		@Override
		CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder getIdentifier();
		CreditSupportAgreement.CreditSupportAgreementBuilder setType(CreditSupportAgreementType type);
		CreditSupportAgreement.CreditSupportAgreementBuilder setDate(ZonedDateTime date);
		CreditSupportAgreement.CreditSupportAgreementBuilder setIdentifier(CreditSupportAgreementIdentifier identifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, CreditSupportAgreementType.CreditSupportAgreementTypeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
			processRosetta(path.newSubPath("identifier"), processor, CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder.class, getIdentifier());
		}
		

		CreditSupportAgreement.CreditSupportAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportAgreement  ***********************/
	class CreditSupportAgreementImpl implements CreditSupportAgreement {
		private final CreditSupportAgreementType type;
		private final ZonedDateTime date;
		private final CreditSupportAgreementIdentifier identifier;
		
		protected CreditSupportAgreementImpl(CreditSupportAgreement.CreditSupportAgreementBuilder builder) {
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.date = builder.getDate();
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public CreditSupportAgreementType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifier")
		public CreditSupportAgreementIdentifier getIdentifier() {
			return identifier;
		}
		
		@Override
		public CreditSupportAgreement build() {
			return this;
		}
		
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder toBuilder() {
			CreditSupportAgreement.CreditSupportAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportAgreement.CreditSupportAgreementBuilder builder) {
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreement _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreement {" +
				"type=" + this.type + ", " +
				"date=" + this.date + ", " +
				"identifier=" + this.identifier +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportAgreement  ***********************/
	class CreditSupportAgreementBuilderImpl implements CreditSupportAgreement.CreditSupportAgreementBuilder {
	
		protected CreditSupportAgreementType.CreditSupportAgreementTypeBuilder type;
		protected ZonedDateTime date;
		protected CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder identifier;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public CreditSupportAgreementType.CreditSupportAgreementTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public CreditSupportAgreementType.CreditSupportAgreementTypeBuilder getOrCreateType() {
			CreditSupportAgreementType.CreditSupportAgreementTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = CreditSupportAgreementType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifier")
		public CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder getOrCreateIdentifier() {
			CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = CreditSupportAgreementIdentifier.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder setType(CreditSupportAgreementType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("identifier")
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder setIdentifier(CreditSupportAgreementIdentifier _identifier) {
			this.identifier = _identifier == null ? null : _identifier.toBuilder();
			return this;
		}
		
		@Override
		public CreditSupportAgreement build() {
			return new CreditSupportAgreement.CreditSupportAgreementImpl(this);
		}
		
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (_getType()!=null && _getType().hasData()) return true;
			if (getDate()!=null) return true;
			if (getIdentifier()!=null && getIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportAgreement.CreditSupportAgreementBuilder o = (CreditSupportAgreement.CreditSupportAgreementBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreement _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementBuilder {" +
				"type=" + this.type + ", " +
				"date=" + this.date + ", " +
				"identifier=" + this.identifier +
			'}';
		}
	}
}
