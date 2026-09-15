package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CoalStandardQualityMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The quality attributes of the coal to be delivered.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The quality attributes of the coal to be delivered.
 *
 */
@RosettaDataType(value="CoalStandardQuality", builder=CoalStandardQuality.CoalStandardQualityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CoalStandardQuality", model="fpml", builder=CoalStandardQuality.CoalStandardQualityBuilderImpl.class, version="2.1.1")
public interface CoalStandardQuality extends RosettaModelObject {

	CoalStandardQualityMeta metaData = new CoalStandardQualityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The moisture content of the coal product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The moisture content of the coal product.
	 *
	 */
	CoalAttributePercentage getMoisture();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ash content of the coal product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ash content of the coal product.
	 *
	 */
	CoalAttributePercentage getAsh();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The sulfur/sulphur content of the coal product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The sulfur/sulphur content of the coal product.
	 *
	 */
	CoalAttributePercentage getSulfur();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The sulfur/sulphur dioxide content of the coal product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The sulfur/sulphur dioxide content of the coal product.
	 *
	 */
	CoalAttributePercentage getSO2();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The volatile content of the coal product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The volatile content of the coal product.
	 *
	 */
	CoalAttributePercentage getVolatile();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of British Thermal Units per Pound of the coal product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of British Thermal Units per Pound of the coal product.
	 *
	 */
	CoalAttributeDecimal getBtUperLB();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The smallest sieve opening that will result in less than 5% of a sample of the coal product remaining.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The smallest sieve opening that will result in less than 5% of a sample of the coal product remaining.
	 *
	 */
	CoalAttributeDecimal getTopSize();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	CoalAttributeDecimal getFinesPassingScreen();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Hardgrove Grindability Index value of the coal to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Hardgrove Grindability Index value of the coal to be delivered.
	 *
	 */
	CoalAttributeDecimal getGrindability();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The temperature at which the ash form of the coal product fuses completely in accordance with the ASTM International D1857 Standard Test Methodology.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The temperature at which the ash form of the coal product fuses completely in accordance with the ASTM International D1857 Standard Test Methodology.
	 *
	 */
	CoalAttributeDecimal getAshFusionTemperature();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The temperature at which an ash cone shows evidence of deformation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The temperature at which an ash cone shows evidence of deformation.
	 *
	 */
	CoalAttributeDecimal getInitialDeformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The temperature at which the height of an ash cone equals its width. (Softening temperature).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The temperature at which the height of an ash cone equals its width. (Softening temperature).
	 *
	 */
	CoalAttributeDecimal getSofteningHeightWidth();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The temperature at which the height of an ash cone equals half its width. (Hemisphere temperature).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The temperature at which the height of an ash cone equals half its width. (Hemisphere temperature).
	 *
	 */
	CoalAttributeDecimal getSofteningHeightHalfWidth();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The temperature at which the ash cone flattens.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The temperature at which the ash cone flattens.
	 *
	 */
	CoalAttributeDecimal getFluid();

	/*********************** Build Methods  ***********************/
	CoalStandardQuality build();
	
	CoalStandardQuality.CoalStandardQualityBuilder toBuilder();
	
	static CoalStandardQuality.CoalStandardQualityBuilder builder() {
		return new CoalStandardQuality.CoalStandardQualityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalStandardQuality> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CoalStandardQuality> getType() {
		return CoalStandardQuality.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("moisture"), processor, CoalAttributePercentage.class, getMoisture());
		processRosetta(path.newSubPath("ash"), processor, CoalAttributePercentage.class, getAsh());
		processRosetta(path.newSubPath("sulfur"), processor, CoalAttributePercentage.class, getSulfur());
		processRosetta(path.newSubPath("sO2"), processor, CoalAttributePercentage.class, getSO2());
		processRosetta(path.newSubPath("volatile"), processor, CoalAttributePercentage.class, getVolatile());
		processRosetta(path.newSubPath("btUperLB"), processor, CoalAttributeDecimal.class, getBtUperLB());
		processRosetta(path.newSubPath("topSize"), processor, CoalAttributeDecimal.class, getTopSize());
		processRosetta(path.newSubPath("finesPassingScreen"), processor, CoalAttributeDecimal.class, getFinesPassingScreen());
		processRosetta(path.newSubPath("grindability"), processor, CoalAttributeDecimal.class, getGrindability());
		processRosetta(path.newSubPath("ashFusionTemperature"), processor, CoalAttributeDecimal.class, getAshFusionTemperature());
		processRosetta(path.newSubPath("initialDeformation"), processor, CoalAttributeDecimal.class, getInitialDeformation());
		processRosetta(path.newSubPath("softeningHeightWidth"), processor, CoalAttributeDecimal.class, getSofteningHeightWidth());
		processRosetta(path.newSubPath("softeningHeightHalfWidth"), processor, CoalAttributeDecimal.class, getSofteningHeightHalfWidth());
		processRosetta(path.newSubPath("fluid"), processor, CoalAttributeDecimal.class, getFluid());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalStandardQualityBuilder extends CoalStandardQuality, RosettaModelObjectBuilder {
		CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateMoisture();
		@Override
		CoalAttributePercentage.CoalAttributePercentageBuilder getMoisture();
		CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateAsh();
		@Override
		CoalAttributePercentage.CoalAttributePercentageBuilder getAsh();
		CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateSulfur();
		@Override
		CoalAttributePercentage.CoalAttributePercentageBuilder getSulfur();
		CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateSO2();
		@Override
		CoalAttributePercentage.CoalAttributePercentageBuilder getSO2();
		CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateVolatile();
		@Override
		CoalAttributePercentage.CoalAttributePercentageBuilder getVolatile();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateBtUperLB();
		@Override
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getBtUperLB();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateTopSize();
		@Override
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getTopSize();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateFinesPassingScreen();
		@Override
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getFinesPassingScreen();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateGrindability();
		@Override
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getGrindability();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateAshFusionTemperature();
		@Override
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getAshFusionTemperature();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateInitialDeformation();
		@Override
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getInitialDeformation();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateSofteningHeightWidth();
		@Override
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getSofteningHeightWidth();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateSofteningHeightHalfWidth();
		@Override
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getSofteningHeightHalfWidth();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateFluid();
		@Override
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getFluid();
		CoalStandardQuality.CoalStandardQualityBuilder setMoisture(CoalAttributePercentage moisture);
		CoalStandardQuality.CoalStandardQualityBuilder setAsh(CoalAttributePercentage ash);
		CoalStandardQuality.CoalStandardQualityBuilder setSulfur(CoalAttributePercentage sulfur);
		CoalStandardQuality.CoalStandardQualityBuilder setSO2(CoalAttributePercentage sO2);
		CoalStandardQuality.CoalStandardQualityBuilder setVolatile(CoalAttributePercentage _volatile);
		CoalStandardQuality.CoalStandardQualityBuilder setBtUperLB(CoalAttributeDecimal btUperLB);
		CoalStandardQuality.CoalStandardQualityBuilder setTopSize(CoalAttributeDecimal topSize);
		CoalStandardQuality.CoalStandardQualityBuilder setFinesPassingScreen(CoalAttributeDecimal finesPassingScreen);
		CoalStandardQuality.CoalStandardQualityBuilder setGrindability(CoalAttributeDecimal grindability);
		CoalStandardQuality.CoalStandardQualityBuilder setAshFusionTemperature(CoalAttributeDecimal ashFusionTemperature);
		CoalStandardQuality.CoalStandardQualityBuilder setInitialDeformation(CoalAttributeDecimal initialDeformation);
		CoalStandardQuality.CoalStandardQualityBuilder setSofteningHeightWidth(CoalAttributeDecimal softeningHeightWidth);
		CoalStandardQuality.CoalStandardQualityBuilder setSofteningHeightHalfWidth(CoalAttributeDecimal softeningHeightHalfWidth);
		CoalStandardQuality.CoalStandardQualityBuilder setFluid(CoalAttributeDecimal fluid);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("moisture"), processor, CoalAttributePercentage.CoalAttributePercentageBuilder.class, getMoisture());
			processRosetta(path.newSubPath("ash"), processor, CoalAttributePercentage.CoalAttributePercentageBuilder.class, getAsh());
			processRosetta(path.newSubPath("sulfur"), processor, CoalAttributePercentage.CoalAttributePercentageBuilder.class, getSulfur());
			processRosetta(path.newSubPath("sO2"), processor, CoalAttributePercentage.CoalAttributePercentageBuilder.class, getSO2());
			processRosetta(path.newSubPath("volatile"), processor, CoalAttributePercentage.CoalAttributePercentageBuilder.class, getVolatile());
			processRosetta(path.newSubPath("btUperLB"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getBtUperLB());
			processRosetta(path.newSubPath("topSize"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getTopSize());
			processRosetta(path.newSubPath("finesPassingScreen"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getFinesPassingScreen());
			processRosetta(path.newSubPath("grindability"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getGrindability());
			processRosetta(path.newSubPath("ashFusionTemperature"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getAshFusionTemperature());
			processRosetta(path.newSubPath("initialDeformation"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getInitialDeformation());
			processRosetta(path.newSubPath("softeningHeightWidth"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getSofteningHeightWidth());
			processRosetta(path.newSubPath("softeningHeightHalfWidth"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getSofteningHeightHalfWidth());
			processRosetta(path.newSubPath("fluid"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getFluid());
		}
		

		CoalStandardQuality.CoalStandardQualityBuilder prune();
	}

	/*********************** Immutable Implementation of CoalStandardQuality  ***********************/
	class CoalStandardQualityImpl implements CoalStandardQuality {
		private final CoalAttributePercentage moisture;
		private final CoalAttributePercentage ash;
		private final CoalAttributePercentage sulfur;
		private final CoalAttributePercentage sO2;
		private final CoalAttributePercentage _volatile;
		private final CoalAttributeDecimal btUperLB;
		private final CoalAttributeDecimal topSize;
		private final CoalAttributeDecimal finesPassingScreen;
		private final CoalAttributeDecimal grindability;
		private final CoalAttributeDecimal ashFusionTemperature;
		private final CoalAttributeDecimal initialDeformation;
		private final CoalAttributeDecimal softeningHeightWidth;
		private final CoalAttributeDecimal softeningHeightHalfWidth;
		private final CoalAttributeDecimal fluid;
		
		protected CoalStandardQualityImpl(CoalStandardQuality.CoalStandardQualityBuilder builder) {
			this.moisture = ofNullable(builder.getMoisture()).map(f->f.build()).orElse(null);
			this.ash = ofNullable(builder.getAsh()).map(f->f.build()).orElse(null);
			this.sulfur = ofNullable(builder.getSulfur()).map(f->f.build()).orElse(null);
			this.sO2 = ofNullable(builder.getSO2()).map(f->f.build()).orElse(null);
			this._volatile = ofNullable(builder.getVolatile()).map(f->f.build()).orElse(null);
			this.btUperLB = ofNullable(builder.getBtUperLB()).map(f->f.build()).orElse(null);
			this.topSize = ofNullable(builder.getTopSize()).map(f->f.build()).orElse(null);
			this.finesPassingScreen = ofNullable(builder.getFinesPassingScreen()).map(f->f.build()).orElse(null);
			this.grindability = ofNullable(builder.getGrindability()).map(f->f.build()).orElse(null);
			this.ashFusionTemperature = ofNullable(builder.getAshFusionTemperature()).map(f->f.build()).orElse(null);
			this.initialDeformation = ofNullable(builder.getInitialDeformation()).map(f->f.build()).orElse(null);
			this.softeningHeightWidth = ofNullable(builder.getSofteningHeightWidth()).map(f->f.build()).orElse(null);
			this.softeningHeightHalfWidth = ofNullable(builder.getSofteningHeightHalfWidth()).map(f->f.build()).orElse(null);
			this.fluid = ofNullable(builder.getFluid()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("moisture")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("moisture")
		public CoalAttributePercentage getMoisture() {
			return moisture;
		}
		
		@Override
		@RosettaAttribute("ash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ash")
		public CoalAttributePercentage getAsh() {
			return ash;
		}
		
		@Override
		@RosettaAttribute("sulfur")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sulfur")
		public CoalAttributePercentage getSulfur() {
			return sulfur;
		}
		
		@Override
		@RosettaAttribute("sO2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sO2")
		public CoalAttributePercentage getSO2() {
			return sO2;
		}
		
		@Override
		@RosettaAttribute("volatile")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("volatile")
		public CoalAttributePercentage getVolatile() {
			return _volatile;
		}
		
		@Override
		@RosettaAttribute("btUperLB")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("btUperLB")
		public CoalAttributeDecimal getBtUperLB() {
			return btUperLB;
		}
		
		@Override
		@RosettaAttribute("topSize")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("topSize")
		public CoalAttributeDecimal getTopSize() {
			return topSize;
		}
		
		@Override
		@RosettaAttribute("finesPassingScreen")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finesPassingScreen")
		public CoalAttributeDecimal getFinesPassingScreen() {
			return finesPassingScreen;
		}
		
		@Override
		@RosettaAttribute("grindability")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("grindability")
		public CoalAttributeDecimal getGrindability() {
			return grindability;
		}
		
		@Override
		@RosettaAttribute("ashFusionTemperature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ashFusionTemperature")
		public CoalAttributeDecimal getAshFusionTemperature() {
			return ashFusionTemperature;
		}
		
		@Override
		@RosettaAttribute("initialDeformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialDeformation")
		public CoalAttributeDecimal getInitialDeformation() {
			return initialDeformation;
		}
		
		@Override
		@RosettaAttribute("softeningHeightWidth")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("softeningHeightWidth")
		public CoalAttributeDecimal getSofteningHeightWidth() {
			return softeningHeightWidth;
		}
		
		@Override
		@RosettaAttribute("softeningHeightHalfWidth")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("softeningHeightHalfWidth")
		public CoalAttributeDecimal getSofteningHeightHalfWidth() {
			return softeningHeightHalfWidth;
		}
		
		@Override
		@RosettaAttribute("fluid")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fluid")
		public CoalAttributeDecimal getFluid() {
			return fluid;
		}
		
		@Override
		public CoalStandardQuality build() {
			return this;
		}
		
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder toBuilder() {
			CoalStandardQuality.CoalStandardQualityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalStandardQuality.CoalStandardQualityBuilder builder) {
			ofNullable(getMoisture()).ifPresent(builder::setMoisture);
			ofNullable(getAsh()).ifPresent(builder::setAsh);
			ofNullable(getSulfur()).ifPresent(builder::setSulfur);
			ofNullable(getSO2()).ifPresent(builder::setSO2);
			ofNullable(getVolatile()).ifPresent(builder::setVolatile);
			ofNullable(getBtUperLB()).ifPresent(builder::setBtUperLB);
			ofNullable(getTopSize()).ifPresent(builder::setTopSize);
			ofNullable(getFinesPassingScreen()).ifPresent(builder::setFinesPassingScreen);
			ofNullable(getGrindability()).ifPresent(builder::setGrindability);
			ofNullable(getAshFusionTemperature()).ifPresent(builder::setAshFusionTemperature);
			ofNullable(getInitialDeformation()).ifPresent(builder::setInitialDeformation);
			ofNullable(getSofteningHeightWidth()).ifPresent(builder::setSofteningHeightWidth);
			ofNullable(getSofteningHeightHalfWidth()).ifPresent(builder::setSofteningHeightHalfWidth);
			ofNullable(getFluid()).ifPresent(builder::setFluid);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalStandardQuality _that = getType().cast(o);
		
			if (!Objects.equals(moisture, _that.getMoisture())) return false;
			if (!Objects.equals(ash, _that.getAsh())) return false;
			if (!Objects.equals(sulfur, _that.getSulfur())) return false;
			if (!Objects.equals(sO2, _that.getSO2())) return false;
			if (!Objects.equals(_volatile, _that.getVolatile())) return false;
			if (!Objects.equals(btUperLB, _that.getBtUperLB())) return false;
			if (!Objects.equals(topSize, _that.getTopSize())) return false;
			if (!Objects.equals(finesPassingScreen, _that.getFinesPassingScreen())) return false;
			if (!Objects.equals(grindability, _that.getGrindability())) return false;
			if (!Objects.equals(ashFusionTemperature, _that.getAshFusionTemperature())) return false;
			if (!Objects.equals(initialDeformation, _that.getInitialDeformation())) return false;
			if (!Objects.equals(softeningHeightWidth, _that.getSofteningHeightWidth())) return false;
			if (!Objects.equals(softeningHeightHalfWidth, _that.getSofteningHeightHalfWidth())) return false;
			if (!Objects.equals(fluid, _that.getFluid())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (moisture != null ? moisture.hashCode() : 0);
			_result = 31 * _result + (ash != null ? ash.hashCode() : 0);
			_result = 31 * _result + (sulfur != null ? sulfur.hashCode() : 0);
			_result = 31 * _result + (sO2 != null ? sO2.hashCode() : 0);
			_result = 31 * _result + (_volatile != null ? _volatile.hashCode() : 0);
			_result = 31 * _result + (btUperLB != null ? btUperLB.hashCode() : 0);
			_result = 31 * _result + (topSize != null ? topSize.hashCode() : 0);
			_result = 31 * _result + (finesPassingScreen != null ? finesPassingScreen.hashCode() : 0);
			_result = 31 * _result + (grindability != null ? grindability.hashCode() : 0);
			_result = 31 * _result + (ashFusionTemperature != null ? ashFusionTemperature.hashCode() : 0);
			_result = 31 * _result + (initialDeformation != null ? initialDeformation.hashCode() : 0);
			_result = 31 * _result + (softeningHeightWidth != null ? softeningHeightWidth.hashCode() : 0);
			_result = 31 * _result + (softeningHeightHalfWidth != null ? softeningHeightHalfWidth.hashCode() : 0);
			_result = 31 * _result + (fluid != null ? fluid.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalStandardQuality {" +
				"moisture=" + this.moisture + ", " +
				"ash=" + this.ash + ", " +
				"sulfur=" + this.sulfur + ", " +
				"sO2=" + this.sO2 + ", " +
				"volatile=" + this._volatile + ", " +
				"btUperLB=" + this.btUperLB + ", " +
				"topSize=" + this.topSize + ", " +
				"finesPassingScreen=" + this.finesPassingScreen + ", " +
				"grindability=" + this.grindability + ", " +
				"ashFusionTemperature=" + this.ashFusionTemperature + ", " +
				"initialDeformation=" + this.initialDeformation + ", " +
				"softeningHeightWidth=" + this.softeningHeightWidth + ", " +
				"softeningHeightHalfWidth=" + this.softeningHeightHalfWidth + ", " +
				"fluid=" + this.fluid +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalStandardQuality  ***********************/
	class CoalStandardQualityBuilderImpl implements CoalStandardQuality.CoalStandardQualityBuilder {
	
		protected CoalAttributePercentage.CoalAttributePercentageBuilder moisture;
		protected CoalAttributePercentage.CoalAttributePercentageBuilder ash;
		protected CoalAttributePercentage.CoalAttributePercentageBuilder sulfur;
		protected CoalAttributePercentage.CoalAttributePercentageBuilder sO2;
		protected CoalAttributePercentage.CoalAttributePercentageBuilder _volatile;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder btUperLB;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder topSize;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder finesPassingScreen;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder grindability;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder ashFusionTemperature;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder initialDeformation;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder softeningHeightWidth;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder softeningHeightHalfWidth;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder fluid;
		
		@Override
		@RosettaAttribute("moisture")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("moisture")
		public CoalAttributePercentage.CoalAttributePercentageBuilder getMoisture() {
			return moisture;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateMoisture() {
			CoalAttributePercentage.CoalAttributePercentageBuilder result;
			if (moisture!=null) {
				result = moisture;
			}
			else {
				result = moisture = CoalAttributePercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ash")
		public CoalAttributePercentage.CoalAttributePercentageBuilder getAsh() {
			return ash;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateAsh() {
			CoalAttributePercentage.CoalAttributePercentageBuilder result;
			if (ash!=null) {
				result = ash;
			}
			else {
				result = ash = CoalAttributePercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sulfur")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sulfur")
		public CoalAttributePercentage.CoalAttributePercentageBuilder getSulfur() {
			return sulfur;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateSulfur() {
			CoalAttributePercentage.CoalAttributePercentageBuilder result;
			if (sulfur!=null) {
				result = sulfur;
			}
			else {
				result = sulfur = CoalAttributePercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sO2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sO2")
		public CoalAttributePercentage.CoalAttributePercentageBuilder getSO2() {
			return sO2;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateSO2() {
			CoalAttributePercentage.CoalAttributePercentageBuilder result;
			if (sO2!=null) {
				result = sO2;
			}
			else {
				result = sO2 = CoalAttributePercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("volatile")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("volatile")
		public CoalAttributePercentage.CoalAttributePercentageBuilder getVolatile() {
			return _volatile;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateVolatile() {
			CoalAttributePercentage.CoalAttributePercentageBuilder result;
			if (_volatile!=null) {
				result = _volatile;
			}
			else {
				result = _volatile = CoalAttributePercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("btUperLB")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("btUperLB")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getBtUperLB() {
			return btUperLB;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateBtUperLB() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (btUperLB!=null) {
				result = btUperLB;
			}
			else {
				result = btUperLB = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("topSize")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("topSize")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getTopSize() {
			return topSize;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateTopSize() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (topSize!=null) {
				result = topSize;
			}
			else {
				result = topSize = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finesPassingScreen")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finesPassingScreen")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getFinesPassingScreen() {
			return finesPassingScreen;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateFinesPassingScreen() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (finesPassingScreen!=null) {
				result = finesPassingScreen;
			}
			else {
				result = finesPassingScreen = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("grindability")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("grindability")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getGrindability() {
			return grindability;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateGrindability() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (grindability!=null) {
				result = grindability;
			}
			else {
				result = grindability = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ashFusionTemperature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ashFusionTemperature")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getAshFusionTemperature() {
			return ashFusionTemperature;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateAshFusionTemperature() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (ashFusionTemperature!=null) {
				result = ashFusionTemperature;
			}
			else {
				result = ashFusionTemperature = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialDeformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialDeformation")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getInitialDeformation() {
			return initialDeformation;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateInitialDeformation() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (initialDeformation!=null) {
				result = initialDeformation;
			}
			else {
				result = initialDeformation = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("softeningHeightWidth")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("softeningHeightWidth")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getSofteningHeightWidth() {
			return softeningHeightWidth;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateSofteningHeightWidth() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (softeningHeightWidth!=null) {
				result = softeningHeightWidth;
			}
			else {
				result = softeningHeightWidth = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("softeningHeightHalfWidth")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("softeningHeightHalfWidth")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getSofteningHeightHalfWidth() {
			return softeningHeightHalfWidth;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateSofteningHeightHalfWidth() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (softeningHeightHalfWidth!=null) {
				result = softeningHeightHalfWidth;
			}
			else {
				result = softeningHeightHalfWidth = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fluid")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fluid")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getFluid() {
			return fluid;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateFluid() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (fluid!=null) {
				result = fluid;
			}
			else {
				result = fluid = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("moisture")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("moisture")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setMoisture(CoalAttributePercentage _moisture) {
			this.moisture = _moisture == null ? null : _moisture.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ash")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ash")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setAsh(CoalAttributePercentage _ash) {
			this.ash = _ash == null ? null : _ash.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sulfur")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sulfur")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setSulfur(CoalAttributePercentage _sulfur) {
			this.sulfur = _sulfur == null ? null : _sulfur.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sO2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sO2")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setSO2(CoalAttributePercentage _sO2) {
			this.sO2 = _sO2 == null ? null : _sO2.toBuilder();
			return this;
		}
		
		@RosettaAttribute("volatile")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("volatile")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setVolatile(CoalAttributePercentage __volatile) {
			this._volatile = __volatile == null ? null : __volatile.toBuilder();
			return this;
		}
		
		@RosettaAttribute("btUperLB")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("btUperLB")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setBtUperLB(CoalAttributeDecimal _btUperLB) {
			this.btUperLB = _btUperLB == null ? null : _btUperLB.toBuilder();
			return this;
		}
		
		@RosettaAttribute("topSize")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("topSize")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setTopSize(CoalAttributeDecimal _topSize) {
			this.topSize = _topSize == null ? null : _topSize.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finesPassingScreen")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finesPassingScreen")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setFinesPassingScreen(CoalAttributeDecimal _finesPassingScreen) {
			this.finesPassingScreen = _finesPassingScreen == null ? null : _finesPassingScreen.toBuilder();
			return this;
		}
		
		@RosettaAttribute("grindability")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("grindability")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setGrindability(CoalAttributeDecimal _grindability) {
			this.grindability = _grindability == null ? null : _grindability.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ashFusionTemperature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ashFusionTemperature")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setAshFusionTemperature(CoalAttributeDecimal _ashFusionTemperature) {
			this.ashFusionTemperature = _ashFusionTemperature == null ? null : _ashFusionTemperature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initialDeformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialDeformation")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setInitialDeformation(CoalAttributeDecimal _initialDeformation) {
			this.initialDeformation = _initialDeformation == null ? null : _initialDeformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("softeningHeightWidth")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("softeningHeightWidth")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setSofteningHeightWidth(CoalAttributeDecimal _softeningHeightWidth) {
			this.softeningHeightWidth = _softeningHeightWidth == null ? null : _softeningHeightWidth.toBuilder();
			return this;
		}
		
		@RosettaAttribute("softeningHeightHalfWidth")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("softeningHeightHalfWidth")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setSofteningHeightHalfWidth(CoalAttributeDecimal _softeningHeightHalfWidth) {
			this.softeningHeightHalfWidth = _softeningHeightHalfWidth == null ? null : _softeningHeightHalfWidth.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fluid")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fluid")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder setFluid(CoalAttributeDecimal _fluid) {
			this.fluid = _fluid == null ? null : _fluid.toBuilder();
			return this;
		}
		
		@Override
		public CoalStandardQuality build() {
			return new CoalStandardQuality.CoalStandardQualityImpl(this);
		}
		
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder prune() {
			if (moisture!=null && !moisture.prune().hasData()) moisture = null;
			if (ash!=null && !ash.prune().hasData()) ash = null;
			if (sulfur!=null && !sulfur.prune().hasData()) sulfur = null;
			if (sO2!=null && !sO2.prune().hasData()) sO2 = null;
			if (_volatile!=null && !_volatile.prune().hasData()) _volatile = null;
			if (btUperLB!=null && !btUperLB.prune().hasData()) btUperLB = null;
			if (topSize!=null && !topSize.prune().hasData()) topSize = null;
			if (finesPassingScreen!=null && !finesPassingScreen.prune().hasData()) finesPassingScreen = null;
			if (grindability!=null && !grindability.prune().hasData()) grindability = null;
			if (ashFusionTemperature!=null && !ashFusionTemperature.prune().hasData()) ashFusionTemperature = null;
			if (initialDeformation!=null && !initialDeformation.prune().hasData()) initialDeformation = null;
			if (softeningHeightWidth!=null && !softeningHeightWidth.prune().hasData()) softeningHeightWidth = null;
			if (softeningHeightHalfWidth!=null && !softeningHeightHalfWidth.prune().hasData()) softeningHeightHalfWidth = null;
			if (fluid!=null && !fluid.prune().hasData()) fluid = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMoisture()!=null && getMoisture().hasData()) return true;
			if (getAsh()!=null && getAsh().hasData()) return true;
			if (getSulfur()!=null && getSulfur().hasData()) return true;
			if (getSO2()!=null && getSO2().hasData()) return true;
			if (getVolatile()!=null && getVolatile().hasData()) return true;
			if (getBtUperLB()!=null && getBtUperLB().hasData()) return true;
			if (getTopSize()!=null && getTopSize().hasData()) return true;
			if (getFinesPassingScreen()!=null && getFinesPassingScreen().hasData()) return true;
			if (getGrindability()!=null && getGrindability().hasData()) return true;
			if (getAshFusionTemperature()!=null && getAshFusionTemperature().hasData()) return true;
			if (getInitialDeformation()!=null && getInitialDeformation().hasData()) return true;
			if (getSofteningHeightWidth()!=null && getSofteningHeightWidth().hasData()) return true;
			if (getSofteningHeightHalfWidth()!=null && getSofteningHeightHalfWidth().hasData()) return true;
			if (getFluid()!=null && getFluid().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalStandardQuality.CoalStandardQualityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalStandardQuality.CoalStandardQualityBuilder o = (CoalStandardQuality.CoalStandardQualityBuilder) other;
			
			merger.mergeRosetta(getMoisture(), o.getMoisture(), this::setMoisture);
			merger.mergeRosetta(getAsh(), o.getAsh(), this::setAsh);
			merger.mergeRosetta(getSulfur(), o.getSulfur(), this::setSulfur);
			merger.mergeRosetta(getSO2(), o.getSO2(), this::setSO2);
			merger.mergeRosetta(getVolatile(), o.getVolatile(), this::setVolatile);
			merger.mergeRosetta(getBtUperLB(), o.getBtUperLB(), this::setBtUperLB);
			merger.mergeRosetta(getTopSize(), o.getTopSize(), this::setTopSize);
			merger.mergeRosetta(getFinesPassingScreen(), o.getFinesPassingScreen(), this::setFinesPassingScreen);
			merger.mergeRosetta(getGrindability(), o.getGrindability(), this::setGrindability);
			merger.mergeRosetta(getAshFusionTemperature(), o.getAshFusionTemperature(), this::setAshFusionTemperature);
			merger.mergeRosetta(getInitialDeformation(), o.getInitialDeformation(), this::setInitialDeformation);
			merger.mergeRosetta(getSofteningHeightWidth(), o.getSofteningHeightWidth(), this::setSofteningHeightWidth);
			merger.mergeRosetta(getSofteningHeightHalfWidth(), o.getSofteningHeightHalfWidth(), this::setSofteningHeightHalfWidth);
			merger.mergeRosetta(getFluid(), o.getFluid(), this::setFluid);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalStandardQuality _that = getType().cast(o);
		
			if (!Objects.equals(moisture, _that.getMoisture())) return false;
			if (!Objects.equals(ash, _that.getAsh())) return false;
			if (!Objects.equals(sulfur, _that.getSulfur())) return false;
			if (!Objects.equals(sO2, _that.getSO2())) return false;
			if (!Objects.equals(_volatile, _that.getVolatile())) return false;
			if (!Objects.equals(btUperLB, _that.getBtUperLB())) return false;
			if (!Objects.equals(topSize, _that.getTopSize())) return false;
			if (!Objects.equals(finesPassingScreen, _that.getFinesPassingScreen())) return false;
			if (!Objects.equals(grindability, _that.getGrindability())) return false;
			if (!Objects.equals(ashFusionTemperature, _that.getAshFusionTemperature())) return false;
			if (!Objects.equals(initialDeformation, _that.getInitialDeformation())) return false;
			if (!Objects.equals(softeningHeightWidth, _that.getSofteningHeightWidth())) return false;
			if (!Objects.equals(softeningHeightHalfWidth, _that.getSofteningHeightHalfWidth())) return false;
			if (!Objects.equals(fluid, _that.getFluid())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (moisture != null ? moisture.hashCode() : 0);
			_result = 31 * _result + (ash != null ? ash.hashCode() : 0);
			_result = 31 * _result + (sulfur != null ? sulfur.hashCode() : 0);
			_result = 31 * _result + (sO2 != null ? sO2.hashCode() : 0);
			_result = 31 * _result + (_volatile != null ? _volatile.hashCode() : 0);
			_result = 31 * _result + (btUperLB != null ? btUperLB.hashCode() : 0);
			_result = 31 * _result + (topSize != null ? topSize.hashCode() : 0);
			_result = 31 * _result + (finesPassingScreen != null ? finesPassingScreen.hashCode() : 0);
			_result = 31 * _result + (grindability != null ? grindability.hashCode() : 0);
			_result = 31 * _result + (ashFusionTemperature != null ? ashFusionTemperature.hashCode() : 0);
			_result = 31 * _result + (initialDeformation != null ? initialDeformation.hashCode() : 0);
			_result = 31 * _result + (softeningHeightWidth != null ? softeningHeightWidth.hashCode() : 0);
			_result = 31 * _result + (softeningHeightHalfWidth != null ? softeningHeightHalfWidth.hashCode() : 0);
			_result = 31 * _result + (fluid != null ? fluid.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalStandardQualityBuilder {" +
				"moisture=" + this.moisture + ", " +
				"ash=" + this.ash + ", " +
				"sulfur=" + this.sulfur + ", " +
				"sO2=" + this.sO2 + ", " +
				"volatile=" + this._volatile + ", " +
				"btUperLB=" + this.btUperLB + ", " +
				"topSize=" + this.topSize + ", " +
				"finesPassingScreen=" + this.finesPassingScreen + ", " +
				"grindability=" + this.grindability + ", " +
				"ashFusionTemperature=" + this.ashFusionTemperature + ", " +
				"initialDeformation=" + this.initialDeformation + ", " +
				"softeningHeightWidth=" + this.softeningHeightWidth + ", " +
				"softeningHeightHalfWidth=" + this.softeningHeightHalfWidth + ", " +
				"fluid=" + this.fluid +
			'}';
		}
	}
}
