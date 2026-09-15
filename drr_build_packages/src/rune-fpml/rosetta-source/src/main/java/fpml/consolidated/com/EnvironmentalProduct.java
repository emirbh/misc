package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.EnvironmentalProductMeta;
import fpml.consolidated.fpmlenum.EnvironmentalProductTypeEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the characteristics of the environmental allowance or credit being traded. Settlement of environmental transactions is classified as physical because settlement is accomplished through the exchange of one or more certificates (despite the fact that this exchange is almost always executed through electronic book entry transfer between the parties allowance accounts).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the characteristics of the environmental allowance or credit being traded. Settlement of environmental transactions is classified as physical because settlement is accomplished through the exchange of one or more certificates (despite the fact that this exchange is almost always executed through electronic book entry transfer between the parties allowance accounts).
 *
 */
@RosettaDataType(value="EnvironmentalProduct", builder=EnvironmentalProduct.EnvironmentalProductBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EnvironmentalProduct", model="fpml", builder=EnvironmentalProduct.EnvironmentalProductBuilderImpl.class, version="2.1.1")
public interface EnvironmentalProduct extends RosettaModelObject {

	EnvironmentalProductMeta metaData = new EnvironmentalProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the type of environmental allowance or credit. Examples include allowances or credit issued by the European Union (E.U.) or by the State of California in the Unites States.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the type of environmental allowance or credit. Examples include allowances or credit issued by the European Union (E.U.) or by the State of California in the Unites States.
	 *
	 */
	EnvironmentalProductTypeEnum getProductType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Applies to E.U. Emissions Allowance Transactions. Describes Specified Compliance Period for which the Allowances are issued.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Applies to E.U. Emissions Allowance Transactions. Describes Specified Compliance Period for which the Allowances are issued.
	 *
	 */
	EnvironmentalProductComplaincePeriod getCompliancePeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Applies to U.S. Emissions Allowance Transactions. The year(s) of the applicable Emissions Product(s) as specified in an Emissions Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Applies to U.S. Emissions Allowance Transactions. The year(s) of the applicable Emissions Product(s) as specified in an Emissions Transaction.
	 *
	 */
	List<String> getVintage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Applies to U.S. Emissions Allowance Transactions. Used to specify the Applicable Emissions Law when this is not defined in Emissions Product Definitions Exhibit.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Applies to U.S. Emissions Allowance Transactions. Used to specify the Applicable Emissions Law when this is not defined in Emissions Product Definitions Exhibit.
	 *
	 */
	EnvironmentalProductApplicableLaw getApplicableLaw();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Applies to U.S. Emissions Allowance Transactions. Used to specify the Tracking System when this is not defined in Emissions Product Definitions Exhibit.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Applies to U.S. Emissions Allowance Transactions. Used to specify the Tracking System when this is not defined in Emissions Product Definitions Exhibit.
	 *
	 */
	EnvironmentalTrackingSystem getTrackingSystem();

	/*********************** Build Methods  ***********************/
	EnvironmentalProduct build();
	
	EnvironmentalProduct.EnvironmentalProductBuilder toBuilder();
	
	static EnvironmentalProduct.EnvironmentalProductBuilder builder() {
		return new EnvironmentalProduct.EnvironmentalProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentalProduct> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnvironmentalProduct> getType() {
		return EnvironmentalProduct.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("productType"), EnvironmentalProductTypeEnum.class, getProductType(), this);
		processRosetta(path.newSubPath("compliancePeriod"), processor, EnvironmentalProductComplaincePeriod.class, getCompliancePeriod());
		processor.processBasic(path.newSubPath("vintage"), String.class, getVintage(), this);
		processRosetta(path.newSubPath("applicableLaw"), processor, EnvironmentalProductApplicableLaw.class, getApplicableLaw());
		processRosetta(path.newSubPath("trackingSystem"), processor, EnvironmentalTrackingSystem.class, getTrackingSystem());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentalProductBuilder extends EnvironmentalProduct, RosettaModelObjectBuilder {
		EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder getOrCreateCompliancePeriod();
		@Override
		EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder getCompliancePeriod();
		EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder getOrCreateApplicableLaw();
		@Override
		EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder getApplicableLaw();
		EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder getOrCreateTrackingSystem();
		@Override
		EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder getTrackingSystem();
		EnvironmentalProduct.EnvironmentalProductBuilder setProductType(EnvironmentalProductTypeEnum productType);
		EnvironmentalProduct.EnvironmentalProductBuilder setCompliancePeriod(EnvironmentalProductComplaincePeriod compliancePeriod);
		EnvironmentalProduct.EnvironmentalProductBuilder addVintage(String vintage);
		EnvironmentalProduct.EnvironmentalProductBuilder addVintage(String vintage, int idx);
		EnvironmentalProduct.EnvironmentalProductBuilder addVintage(List<String> vintage);
		EnvironmentalProduct.EnvironmentalProductBuilder setVintage(List<String> vintage);
		EnvironmentalProduct.EnvironmentalProductBuilder setApplicableLaw(EnvironmentalProductApplicableLaw applicableLaw);
		EnvironmentalProduct.EnvironmentalProductBuilder setTrackingSystem(EnvironmentalTrackingSystem trackingSystem);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("productType"), EnvironmentalProductTypeEnum.class, getProductType(), this);
			processRosetta(path.newSubPath("compliancePeriod"), processor, EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder.class, getCompliancePeriod());
			processor.processBasic(path.newSubPath("vintage"), String.class, getVintage(), this);
			processRosetta(path.newSubPath("applicableLaw"), processor, EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder.class, getApplicableLaw());
			processRosetta(path.newSubPath("trackingSystem"), processor, EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder.class, getTrackingSystem());
		}
		

		EnvironmentalProduct.EnvironmentalProductBuilder prune();
	}

	/*********************** Immutable Implementation of EnvironmentalProduct  ***********************/
	class EnvironmentalProductImpl implements EnvironmentalProduct {
		private final EnvironmentalProductTypeEnum productType;
		private final EnvironmentalProductComplaincePeriod compliancePeriod;
		private final List<String> vintage;
		private final EnvironmentalProductApplicableLaw applicableLaw;
		private final EnvironmentalTrackingSystem trackingSystem;
		
		protected EnvironmentalProductImpl(EnvironmentalProduct.EnvironmentalProductBuilder builder) {
			this.productType = builder.getProductType();
			this.compliancePeriod = ofNullable(builder.getCompliancePeriod()).map(f->f.build()).orElse(null);
			this.vintage = ofNullable(builder.getVintage()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.applicableLaw = ofNullable(builder.getApplicableLaw()).map(f->f.build()).orElse(null);
			this.trackingSystem = ofNullable(builder.getTrackingSystem()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("productType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("productType")
		public EnvironmentalProductTypeEnum getProductType() {
			return productType;
		}
		
		@Override
		@RosettaAttribute("compliancePeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compliancePeriod")
		public EnvironmentalProductComplaincePeriod getCompliancePeriod() {
			return compliancePeriod;
		}
		
		@Override
		@RosettaAttribute("vintage")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("vintage")
		public List<String> getVintage() {
			return vintage;
		}
		
		@Override
		@RosettaAttribute("applicableLaw")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableLaw")
		public EnvironmentalProductApplicableLaw getApplicableLaw() {
			return applicableLaw;
		}
		
		@Override
		@RosettaAttribute("trackingSystem")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trackingSystem")
		public EnvironmentalTrackingSystem getTrackingSystem() {
			return trackingSystem;
		}
		
		@Override
		public EnvironmentalProduct build() {
			return this;
		}
		
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder toBuilder() {
			EnvironmentalProduct.EnvironmentalProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentalProduct.EnvironmentalProductBuilder builder) {
			ofNullable(getProductType()).ifPresent(builder::setProductType);
			ofNullable(getCompliancePeriod()).ifPresent(builder::setCompliancePeriod);
			ofNullable(getVintage()).ifPresent(builder::setVintage);
			ofNullable(getApplicableLaw()).ifPresent(builder::setApplicableLaw);
			ofNullable(getTrackingSystem()).ifPresent(builder::setTrackingSystem);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalProduct _that = getType().cast(o);
		
			if (!Objects.equals(productType, _that.getProductType())) return false;
			if (!Objects.equals(compliancePeriod, _that.getCompliancePeriod())) return false;
			if (!ListEquals.listEquals(vintage, _that.getVintage())) return false;
			if (!Objects.equals(applicableLaw, _that.getApplicableLaw())) return false;
			if (!Objects.equals(trackingSystem, _that.getTrackingSystem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (productType != null ? productType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (compliancePeriod != null ? compliancePeriod.hashCode() : 0);
			_result = 31 * _result + (vintage != null ? vintage.hashCode() : 0);
			_result = 31 * _result + (applicableLaw != null ? applicableLaw.hashCode() : 0);
			_result = 31 * _result + (trackingSystem != null ? trackingSystem.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalProduct {" +
				"productType=" + this.productType + ", " +
				"compliancePeriod=" + this.compliancePeriod + ", " +
				"vintage=" + this.vintage + ", " +
				"applicableLaw=" + this.applicableLaw + ", " +
				"trackingSystem=" + this.trackingSystem +
			'}';
		}
	}

	/*********************** Builder Implementation of EnvironmentalProduct  ***********************/
	class EnvironmentalProductBuilderImpl implements EnvironmentalProduct.EnvironmentalProductBuilder {
	
		protected EnvironmentalProductTypeEnum productType;
		protected EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder compliancePeriod;
		protected List<String> vintage = new ArrayList<>();
		protected EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder applicableLaw;
		protected EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder trackingSystem;
		
		@Override
		@RosettaAttribute("productType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("productType")
		public EnvironmentalProductTypeEnum getProductType() {
			return productType;
		}
		
		@Override
		@RosettaAttribute("compliancePeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compliancePeriod")
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder getCompliancePeriod() {
			return compliancePeriod;
		}
		
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder getOrCreateCompliancePeriod() {
			EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder result;
			if (compliancePeriod!=null) {
				result = compliancePeriod;
			}
			else {
				result = compliancePeriod = EnvironmentalProductComplaincePeriod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vintage")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("vintage")
		public List<String> getVintage() {
			return vintage;
		}
		
		@Override
		@RosettaAttribute("applicableLaw")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableLaw")
		public EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder getApplicableLaw() {
			return applicableLaw;
		}
		
		@Override
		public EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder getOrCreateApplicableLaw() {
			EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder result;
			if (applicableLaw!=null) {
				result = applicableLaw;
			}
			else {
				result = applicableLaw = EnvironmentalProductApplicableLaw.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trackingSystem")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trackingSystem")
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder getTrackingSystem() {
			return trackingSystem;
		}
		
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder getOrCreateTrackingSystem() {
			EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder result;
			if (trackingSystem!=null) {
				result = trackingSystem;
			}
			else {
				result = trackingSystem = EnvironmentalTrackingSystem.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("productType")
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder setProductType(EnvironmentalProductTypeEnum _productType) {
			this.productType = _productType == null ? null : _productType;
			return this;
		}
		
		@RosettaAttribute("compliancePeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compliancePeriod")
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder setCompliancePeriod(EnvironmentalProductComplaincePeriod _compliancePeriod) {
			this.compliancePeriod = _compliancePeriod == null ? null : _compliancePeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vintage")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("vintage")
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder addVintage(String _vintage) {
			if (_vintage != null) {
				this.vintage.add(_vintage);
			}
			return this;
		}
		
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder addVintage(String _vintage, int idx) {
			getIndex(this.vintage, idx, () -> _vintage);
			return this;
		}
		
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder addVintage(List<String> vintages) {
			if (vintages != null) {
				for (final String toAdd : vintages) {
					this.vintage.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("vintage")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("vintage")
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder setVintage(List<String> vintages) {
			if (vintages == null) {
				this.vintage = new ArrayList<>();
			} else {
				this.vintage = vintages.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("applicableLaw")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicableLaw")
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder setApplicableLaw(EnvironmentalProductApplicableLaw _applicableLaw) {
			this.applicableLaw = _applicableLaw == null ? null : _applicableLaw.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trackingSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trackingSystem")
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder setTrackingSystem(EnvironmentalTrackingSystem _trackingSystem) {
			this.trackingSystem = _trackingSystem == null ? null : _trackingSystem.toBuilder();
			return this;
		}
		
		@Override
		public EnvironmentalProduct build() {
			return new EnvironmentalProduct.EnvironmentalProductImpl(this);
		}
		
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder prune() {
			if (compliancePeriod!=null && !compliancePeriod.prune().hasData()) compliancePeriod = null;
			if (applicableLaw!=null && !applicableLaw.prune().hasData()) applicableLaw = null;
			if (trackingSystem!=null && !trackingSystem.prune().hasData()) trackingSystem = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getProductType()!=null) return true;
			if (getCompliancePeriod()!=null && getCompliancePeriod().hasData()) return true;
			if (getVintage()!=null && !getVintage().isEmpty()) return true;
			if (getApplicableLaw()!=null && getApplicableLaw().hasData()) return true;
			if (getTrackingSystem()!=null && getTrackingSystem().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnvironmentalProduct.EnvironmentalProductBuilder o = (EnvironmentalProduct.EnvironmentalProductBuilder) other;
			
			merger.mergeRosetta(getCompliancePeriod(), o.getCompliancePeriod(), this::setCompliancePeriod);
			merger.mergeRosetta(getApplicableLaw(), o.getApplicableLaw(), this::setApplicableLaw);
			merger.mergeRosetta(getTrackingSystem(), o.getTrackingSystem(), this::setTrackingSystem);
			
			merger.mergeBasic(getProductType(), o.getProductType(), this::setProductType);
			merger.mergeBasic(getVintage(), o.getVintage(), (Consumer<String>) this::addVintage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalProduct _that = getType().cast(o);
		
			if (!Objects.equals(productType, _that.getProductType())) return false;
			if (!Objects.equals(compliancePeriod, _that.getCompliancePeriod())) return false;
			if (!ListEquals.listEquals(vintage, _that.getVintage())) return false;
			if (!Objects.equals(applicableLaw, _that.getApplicableLaw())) return false;
			if (!Objects.equals(trackingSystem, _that.getTrackingSystem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (productType != null ? productType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (compliancePeriod != null ? compliancePeriod.hashCode() : 0);
			_result = 31 * _result + (vintage != null ? vintage.hashCode() : 0);
			_result = 31 * _result + (applicableLaw != null ? applicableLaw.hashCode() : 0);
			_result = 31 * _result + (trackingSystem != null ? trackingSystem.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalProductBuilder {" +
				"productType=" + this.productType + ", " +
				"compliancePeriod=" + this.compliancePeriod + ", " +
				"vintage=" + this.vintage + ", " +
				"applicableLaw=" + this.applicableLaw + ", " +
				"trackingSystem=" + this.trackingSystem +
			'}';
		}
	}
}
