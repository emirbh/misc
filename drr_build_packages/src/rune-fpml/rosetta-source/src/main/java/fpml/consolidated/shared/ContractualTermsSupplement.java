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
import fpml.consolidated.shared.meta.ContractualTermsSupplementMeta;
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
 * Provision A contractual supplement (such as those published by ISDA) and its publication date that will apply to the trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A contractual supplement (such as those published by ISDA) and its publication date that will apply to the trade.
 *
 */
@RosettaDataType(value="ContractualTermsSupplement", builder=ContractualTermsSupplement.ContractualTermsSupplementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ContractualTermsSupplement", model="fpml", builder=ContractualTermsSupplement.ContractualTermsSupplementBuilderImpl.class, version="2.1.1")
public interface ContractualTermsSupplement extends RosettaModelObject {

	ContractualTermsSupplementMeta metaData = new ContractualTermsSupplementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the form of applicable contractual supplement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the form of applicable contractual supplement.
	 *
	 */
	ContractualSupplement _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the publication date of the applicable version of the contractual supplement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the publication date of the applicable version of the contractual supplement.
	 *
	 */
	ZonedDateTime getPublicationDate();

	/*********************** Build Methods  ***********************/
	ContractualTermsSupplement build();
	
	ContractualTermsSupplement.ContractualTermsSupplementBuilder toBuilder();
	
	static ContractualTermsSupplement.ContractualTermsSupplementBuilder builder() {
		return new ContractualTermsSupplement.ContractualTermsSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractualTermsSupplement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractualTermsSupplement> getType() {
		return ContractualTermsSupplement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, ContractualSupplement.class, _getType());
		processor.processBasic(path.newSubPath("publicationDate"), ZonedDateTime.class, getPublicationDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractualTermsSupplementBuilder extends ContractualTermsSupplement, RosettaModelObjectBuilder {
		ContractualSupplement.ContractualSupplementBuilder getOrCreateType();
		@Override
		ContractualSupplement.ContractualSupplementBuilder _getType();
		ContractualTermsSupplement.ContractualTermsSupplementBuilder setType(ContractualSupplement type);
		ContractualTermsSupplement.ContractualTermsSupplementBuilder setPublicationDate(ZonedDateTime publicationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, ContractualSupplement.ContractualSupplementBuilder.class, _getType());
			processor.processBasic(path.newSubPath("publicationDate"), ZonedDateTime.class, getPublicationDate(), this);
		}
		

		ContractualTermsSupplement.ContractualTermsSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of ContractualTermsSupplement  ***********************/
	class ContractualTermsSupplementImpl implements ContractualTermsSupplement {
		private final ContractualSupplement type;
		private final ZonedDateTime publicationDate;
		
		protected ContractualTermsSupplementImpl(ContractualTermsSupplement.ContractualTermsSupplementBuilder builder) {
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.publicationDate = builder.getPublicationDate();
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public ContractualSupplement _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("publicationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publicationDate")
		public ZonedDateTime getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		public ContractualTermsSupplement build() {
			return this;
		}
		
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder toBuilder() {
			ContractualTermsSupplement.ContractualTermsSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractualTermsSupplement.ContractualTermsSupplementBuilder builder) {
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getPublicationDate()).ifPresent(builder::setPublicationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualTermsSupplement _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualTermsSupplement {" +
				"type=" + this.type + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractualTermsSupplement  ***********************/
	class ContractualTermsSupplementBuilderImpl implements ContractualTermsSupplement.ContractualTermsSupplementBuilder {
	
		protected ContractualSupplement.ContractualSupplementBuilder type;
		protected ZonedDateTime publicationDate;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public ContractualSupplement.ContractualSupplementBuilder _getType() {
			return type;
		}
		
		@Override
		public ContractualSupplement.ContractualSupplementBuilder getOrCreateType() {
			ContractualSupplement.ContractualSupplementBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = ContractualSupplement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publicationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publicationDate")
		public ZonedDateTime getPublicationDate() {
			return publicationDate;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder setType(ContractualSupplement _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("publicationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("publicationDate")
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder setPublicationDate(ZonedDateTime _publicationDate) {
			this.publicationDate = _publicationDate == null ? null : _publicationDate;
			return this;
		}
		
		@Override
		public ContractualTermsSupplement build() {
			return new ContractualTermsSupplement.ContractualTermsSupplementImpl(this);
		}
		
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (_getType()!=null && _getType().hasData()) return true;
			if (getPublicationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractualTermsSupplement.ContractualTermsSupplementBuilder o = (ContractualTermsSupplement.ContractualTermsSupplementBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			merger.mergeBasic(getPublicationDate(), o.getPublicationDate(), this::setPublicationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualTermsSupplement _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualTermsSupplementBuilder {" +
				"type=" + this.type + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}
}
