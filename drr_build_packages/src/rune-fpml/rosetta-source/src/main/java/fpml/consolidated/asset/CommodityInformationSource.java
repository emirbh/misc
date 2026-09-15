package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.CommodityInformationSourceMeta;
import fpml.consolidated.shared.RateSourcePage;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the source of a commodity rate, price or index or of a market rate or of a conversion factor (e.g. a fx conversion factor).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the source of a commodity rate, price or index or of a market rate or of a conversion factor (e.g. a fx conversion factor).
 *
 */
@RosettaDataType(value="CommodityInformationSource", builder=CommodityInformationSource.CommodityInformationSourceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityInformationSource", model="fpml", builder=CommodityInformationSource.CommodityInformationSourceBuilderImpl.class, version="2.1.1")
public interface CommodityInformationSource extends RosettaModelObject {

	CommodityInformationSourceMeta metaData = new CommodityInformationSourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The publication in which the rate, price, index or factor is to be found. (e.g Gas Daily, Platts Bloomberg.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The publication in which the rate, price, index or factor is to be found. (e.g Gas Daily, Platts Bloomberg.)
	 *
	 */
	CommodityInformationProvider getRateSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A specific page or screen (in the case of electronically published information) on which the rate source is to be found.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A specific page or screen (in the case of electronically published information) on which the rate source is to be found.
	 *
	 */
	RateSourcePage getRateSourcePage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The heading for the rate source on a given rate source page or screen.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The heading for the rate source on a given rate source page or screen.
	 *
	 */
	String getRateSourcePageHeading();

	/*********************** Build Methods  ***********************/
	CommodityInformationSource build();
	
	CommodityInformationSource.CommodityInformationSourceBuilder toBuilder();
	
	static CommodityInformationSource.CommodityInformationSourceBuilder builder() {
		return new CommodityInformationSource.CommodityInformationSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityInformationSource> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityInformationSource> getType() {
		return CommodityInformationSource.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rateSource"), processor, CommodityInformationProvider.class, getRateSource());
		processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.class, getRateSourcePage());
		processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityInformationSourceBuilder extends CommodityInformationSource, RosettaModelObjectBuilder {
		CommodityInformationProvider.CommodityInformationProviderBuilder getOrCreateRateSource();
		@Override
		CommodityInformationProvider.CommodityInformationProviderBuilder getRateSource();
		RateSourcePage.RateSourcePageBuilder getOrCreateRateSourcePage();
		@Override
		RateSourcePage.RateSourcePageBuilder getRateSourcePage();
		CommodityInformationSource.CommodityInformationSourceBuilder setRateSource(CommodityInformationProvider rateSource);
		CommodityInformationSource.CommodityInformationSourceBuilder setRateSourcePage(RateSourcePage rateSourcePage);
		CommodityInformationSource.CommodityInformationSourceBuilder setRateSourcePageHeading(String rateSourcePageHeading);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rateSource"), processor, CommodityInformationProvider.CommodityInformationProviderBuilder.class, getRateSource());
			processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.RateSourcePageBuilder.class, getRateSourcePage());
			processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
		}
		

		CommodityInformationSource.CommodityInformationSourceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityInformationSource  ***********************/
	class CommodityInformationSourceImpl implements CommodityInformationSource {
		private final CommodityInformationProvider rateSource;
		private final RateSourcePage rateSourcePage;
		private final String rateSourcePageHeading;
		
		protected CommodityInformationSourceImpl(CommodityInformationSource.CommodityInformationSourceBuilder builder) {
			this.rateSource = ofNullable(builder.getRateSource()).map(f->f.build()).orElse(null);
			this.rateSourcePage = ofNullable(builder.getRateSourcePage()).map(f->f.build()).orElse(null);
			this.rateSourcePageHeading = builder.getRateSourcePageHeading();
		}
		
		@Override
		@RosettaAttribute("rateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSource")
		public CommodityInformationProvider getRateSource() {
			return rateSource;
		}
		
		@Override
		@RosettaAttribute("rateSourcePage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSourcePage")
		public RateSourcePage getRateSourcePage() {
			return rateSourcePage;
		}
		
		@Override
		@RosettaAttribute("rateSourcePageHeading")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSourcePageHeading")
		public String getRateSourcePageHeading() {
			return rateSourcePageHeading;
		}
		
		@Override
		public CommodityInformationSource build() {
			return this;
		}
		
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder toBuilder() {
			CommodityInformationSource.CommodityInformationSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityInformationSource.CommodityInformationSourceBuilder builder) {
			ofNullable(getRateSource()).ifPresent(builder::setRateSource);
			ofNullable(getRateSourcePage()).ifPresent(builder::setRateSourcePage);
			ofNullable(getRateSourcePageHeading()).ifPresent(builder::setRateSourcePageHeading);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityInformationSource _that = getType().cast(o);
		
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			if (!Objects.equals(rateSourcePage, _that.getRateSourcePage())) return false;
			if (!Objects.equals(rateSourcePageHeading, _that.getRateSourcePageHeading())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rateSource != null ? rateSource.hashCode() : 0);
			_result = 31 * _result + (rateSourcePage != null ? rateSourcePage.hashCode() : 0);
			_result = 31 * _result + (rateSourcePageHeading != null ? rateSourcePageHeading.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityInformationSource {" +
				"rateSource=" + this.rateSource + ", " +
				"rateSourcePage=" + this.rateSourcePage + ", " +
				"rateSourcePageHeading=" + this.rateSourcePageHeading +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityInformationSource  ***********************/
	class CommodityInformationSourceBuilderImpl implements CommodityInformationSource.CommodityInformationSourceBuilder {
	
		protected CommodityInformationProvider.CommodityInformationProviderBuilder rateSource;
		protected RateSourcePage.RateSourcePageBuilder rateSourcePage;
		protected String rateSourcePageHeading;
		
		@Override
		@RosettaAttribute("rateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSource")
		public CommodityInformationProvider.CommodityInformationProviderBuilder getRateSource() {
			return rateSource;
		}
		
		@Override
		public CommodityInformationProvider.CommodityInformationProviderBuilder getOrCreateRateSource() {
			CommodityInformationProvider.CommodityInformationProviderBuilder result;
			if (rateSource!=null) {
				result = rateSource;
			}
			else {
				result = rateSource = CommodityInformationProvider.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateSourcePage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSourcePage")
		public RateSourcePage.RateSourcePageBuilder getRateSourcePage() {
			return rateSourcePage;
		}
		
		@Override
		public RateSourcePage.RateSourcePageBuilder getOrCreateRateSourcePage() {
			RateSourcePage.RateSourcePageBuilder result;
			if (rateSourcePage!=null) {
				result = rateSourcePage;
			}
			else {
				result = rateSourcePage = RateSourcePage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rateSourcePageHeading")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSourcePageHeading")
		public String getRateSourcePageHeading() {
			return rateSourcePageHeading;
		}
		
		@RosettaAttribute("rateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSource")
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder setRateSource(CommodityInformationProvider _rateSource) {
			this.rateSource = _rateSource == null ? null : _rateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateSourcePage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSourcePage")
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder setRateSourcePage(RateSourcePage _rateSourcePage) {
			this.rateSourcePage = _rateSourcePage == null ? null : _rateSourcePage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateSourcePageHeading")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSourcePageHeading")
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder setRateSourcePageHeading(String _rateSourcePageHeading) {
			this.rateSourcePageHeading = _rateSourcePageHeading == null ? null : _rateSourcePageHeading;
			return this;
		}
		
		@Override
		public CommodityInformationSource build() {
			return new CommodityInformationSource.CommodityInformationSourceImpl(this);
		}
		
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder prune() {
			if (rateSource!=null && !rateSource.prune().hasData()) rateSource = null;
			if (rateSourcePage!=null && !rateSourcePage.prune().hasData()) rateSourcePage = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRateSource()!=null && getRateSource().hasData()) return true;
			if (getRateSourcePage()!=null && getRateSourcePage().hasData()) return true;
			if (getRateSourcePageHeading()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityInformationSource.CommodityInformationSourceBuilder o = (CommodityInformationSource.CommodityInformationSourceBuilder) other;
			
			merger.mergeRosetta(getRateSource(), o.getRateSource(), this::setRateSource);
			merger.mergeRosetta(getRateSourcePage(), o.getRateSourcePage(), this::setRateSourcePage);
			
			merger.mergeBasic(getRateSourcePageHeading(), o.getRateSourcePageHeading(), this::setRateSourcePageHeading);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityInformationSource _that = getType().cast(o);
		
			if (!Objects.equals(rateSource, _that.getRateSource())) return false;
			if (!Objects.equals(rateSourcePage, _that.getRateSourcePage())) return false;
			if (!Objects.equals(rateSourcePageHeading, _that.getRateSourcePageHeading())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rateSource != null ? rateSource.hashCode() : 0);
			_result = 31 * _result + (rateSourcePage != null ? rateSourcePage.hashCode() : 0);
			_result = 31 * _result + (rateSourcePageHeading != null ? rateSourcePageHeading.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityInformationSourceBuilder {" +
				"rateSource=" + this.rateSource + ", " +
				"rateSourcePage=" + this.rateSourcePage + ", " +
				"rateSourcePageHeading=" + this.rateSourcePageHeading +
			'}';
		}
	}
}
