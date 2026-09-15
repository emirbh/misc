package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.OtherAgreementMeta;
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
 * Provision An entity for defining the an agreement executed between parties.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An entity for defining the an agreement executed between parties.
 *
 */
@RosettaDataType(value="OtherAgreement", builder=OtherAgreement.OtherAgreementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OtherAgreement", model="fpml", builder=OtherAgreement.OtherAgreementBuilderImpl.class, version="2.1.1")
public interface OtherAgreement extends RosettaModelObject {

	OtherAgreementMeta metaData = new OtherAgreementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An identifier that has been created to identify the agreement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An identifier that has been created to identify the agreement.
	 *
	 */
	List<? extends OtherAgreementId> getIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The agreement executed between the parties and intended to govern product-specific derivatives transactions between those parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The agreement executed between the parties and intended to govern product-specific derivatives transactions between those parties.
	 *
	 */
	OtherAgreementType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The version of the agreement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The version of the agreement.
	 *
	 */
	OtherAgreementVersion getVersion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the agreement was signed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the agreement was signed.
	 *
	 */
	ZonedDateTime getDate();

	/*********************** Build Methods  ***********************/
	OtherAgreement build();
	
	OtherAgreement.OtherAgreementBuilder toBuilder();
	
	static OtherAgreement.OtherAgreementBuilder builder() {
		return new OtherAgreement.OtherAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherAgreement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OtherAgreement> getType() {
		return OtherAgreement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, OtherAgreementId.class, getIdentifier());
		processRosetta(path.newSubPath("type"), processor, OtherAgreementType.class, _getType());
		processRosetta(path.newSubPath("version"), processor, OtherAgreementVersion.class, getVersion());
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherAgreementBuilder extends OtherAgreement, RosettaModelObjectBuilder {
		OtherAgreementId.OtherAgreementIdBuilder getOrCreateIdentifier(int index);
		@Override
		List<? extends OtherAgreementId.OtherAgreementIdBuilder> getIdentifier();
		OtherAgreementType.OtherAgreementTypeBuilder getOrCreateType();
		@Override
		OtherAgreementType.OtherAgreementTypeBuilder _getType();
		OtherAgreementVersion.OtherAgreementVersionBuilder getOrCreateVersion();
		@Override
		OtherAgreementVersion.OtherAgreementVersionBuilder getVersion();
		OtherAgreement.OtherAgreementBuilder addIdentifier(OtherAgreementId identifier);
		OtherAgreement.OtherAgreementBuilder addIdentifier(OtherAgreementId identifier, int idx);
		OtherAgreement.OtherAgreementBuilder addIdentifier(List<? extends OtherAgreementId> identifier);
		OtherAgreement.OtherAgreementBuilder setIdentifier(List<? extends OtherAgreementId> identifier);
		OtherAgreement.OtherAgreementBuilder setType(OtherAgreementType type);
		OtherAgreement.OtherAgreementBuilder setVersion(OtherAgreementVersion version);
		OtherAgreement.OtherAgreementBuilder setDate(ZonedDateTime date);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, OtherAgreementId.OtherAgreementIdBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("type"), processor, OtherAgreementType.OtherAgreementTypeBuilder.class, _getType());
			processRosetta(path.newSubPath("version"), processor, OtherAgreementVersion.OtherAgreementVersionBuilder.class, getVersion());
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		}
		

		OtherAgreement.OtherAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of OtherAgreement  ***********************/
	class OtherAgreementImpl implements OtherAgreement {
		private final List<? extends OtherAgreementId> identifier;
		private final OtherAgreementType type;
		private final OtherAgreementVersion version;
		private final ZonedDateTime date;
		
		protected OtherAgreementImpl(OtherAgreement.OtherAgreementBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.version = ofNullable(builder.getVersion()).map(f->f.build()).orElse(null);
			this.date = builder.getDate();
		}
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("identifier")
		public List<? extends OtherAgreementId> getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public OtherAgreementType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("version")
		public OtherAgreementVersion getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		public OtherAgreement build() {
			return this;
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder toBuilder() {
			OtherAgreement.OtherAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherAgreement.OtherAgreementBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getDate()).ifPresent(builder::setDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreement {" +
				"identifier=" + this.identifier + ", " +
				"type=" + this.type + ", " +
				"version=" + this.version + ", " +
				"date=" + this.date +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherAgreement  ***********************/
	class OtherAgreementBuilderImpl implements OtherAgreement.OtherAgreementBuilder {
	
		protected List<OtherAgreementId.OtherAgreementIdBuilder> identifier = new ArrayList<>();
		protected OtherAgreementType.OtherAgreementTypeBuilder type;
		protected OtherAgreementVersion.OtherAgreementVersionBuilder version;
		protected ZonedDateTime date;
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("identifier")
		public List<? extends OtherAgreementId.OtherAgreementIdBuilder> getIdentifier() {
			return identifier;
		}
		
		@Override
		public OtherAgreementId.OtherAgreementIdBuilder getOrCreateIdentifier(int index) {
			if (identifier==null) {
				this.identifier = new ArrayList<>();
			}
			return getIndex(identifier, index, () -> {
						OtherAgreementId.OtherAgreementIdBuilder newIdentifier = OtherAgreementId.builder();
						return newIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public OtherAgreementType.OtherAgreementTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder getOrCreateType() {
			OtherAgreementType.OtherAgreementTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = OtherAgreementType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("version")
		public OtherAgreementVersion.OtherAgreementVersionBuilder getVersion() {
			return version;
		}
		
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder getOrCreateVersion() {
			OtherAgreementVersion.OtherAgreementVersionBuilder result;
			if (version!=null) {
				result = version;
			}
			else {
				result = version = OtherAgreementVersion.builder();
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
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("identifier")
		@Override
		public OtherAgreement.OtherAgreementBuilder addIdentifier(OtherAgreementId _identifier) {
			if (_identifier != null) {
				this.identifier.add(_identifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder addIdentifier(OtherAgreementId _identifier, int idx) {
			getIndex(this.identifier, idx, () -> _identifier.toBuilder());
			return this;
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder addIdentifier(List<? extends OtherAgreementId> identifiers) {
			if (identifiers != null) {
				for (final OtherAgreementId toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("identifier")
		@Override
		public OtherAgreement.OtherAgreementBuilder setIdentifier(List<? extends OtherAgreementId> identifiers) {
			if (identifiers == null) {
				this.identifier = new ArrayList<>();
			} else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public OtherAgreement.OtherAgreementBuilder setType(OtherAgreementType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("version")
		@Override
		public OtherAgreement.OtherAgreementBuilder setVersion(OtherAgreementVersion _version) {
			this.version = _version == null ? null : _version.toBuilder();
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public OtherAgreement.OtherAgreementBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@Override
		public OtherAgreement build() {
			return new OtherAgreement.OtherAgreementImpl(this);
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreement.OtherAgreementBuilder prune() {
			identifier = identifier.stream().filter(b->b!=null).<OtherAgreementId.OtherAgreementIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (type!=null && !type.prune().hasData()) type = null;
			if (version!=null && !version.prune().hasData()) version = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			if (getVersion()!=null && getVersion().hasData()) return true;
			if (getDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreement.OtherAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherAgreement.OtherAgreementBuilder o = (OtherAgreement.OtherAgreementBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::getOrCreateIdentifier);
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			merger.mergeRosetta(getVersion(), o.getVersion(), this::setVersion);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementBuilder {" +
				"identifier=" + this.identifier + ", " +
				"type=" + this.type + ", " +
				"version=" + this.version + ", " +
				"date=" + this.date +
			'}';
		}
	}
}
