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
import fpml.consolidated.shared.meta.InformationSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the source for a piece of information (e.g. a rate refix or an fx fixing).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the source for a piece of information (e.g. a rate refix or an fx fixing).
 *
 */
@RosettaDataType(value="InformationSource", builder=InformationSource.InformationSourceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InformationSource", model="fpml", builder=InformationSource.InformationSourceBuilderImpl.class, version="2.1.1")
public interface InformationSource extends RosettaModelObject {

	InformationSourceMeta metaData = new InformationSourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An information source for obtaining a market rate. For example Bloomberg, Reuters, Telerate etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An information source for obtaining a market rate. For example Bloomberg, Reuters, Telerate etc.
	 *
	 */
	InformationProvider getRateSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A specific page for the rate source for obtaining a market rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A specific page for the rate source for obtaining a market rate.
	 *
	 */
	RateSourcePage getRateSourcePage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The heading for the rate source on a given rate source page.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The heading for the rate source on a given rate source page.
	 *
	 */
	String getRateSourcePageHeading();

	/*********************** Build Methods  ***********************/
	InformationSource build();
	
	InformationSource.InformationSourceBuilder toBuilder();
	
	static InformationSource.InformationSourceBuilder builder() {
		return new InformationSource.InformationSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InformationSource> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InformationSource> getType() {
		return InformationSource.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rateSource"), processor, InformationProvider.class, getRateSource());
		processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.class, getRateSourcePage());
		processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InformationSourceBuilder extends InformationSource, RosettaModelObjectBuilder {
		InformationProvider.InformationProviderBuilder getOrCreateRateSource();
		@Override
		InformationProvider.InformationProviderBuilder getRateSource();
		RateSourcePage.RateSourcePageBuilder getOrCreateRateSourcePage();
		@Override
		RateSourcePage.RateSourcePageBuilder getRateSourcePage();
		InformationSource.InformationSourceBuilder setRateSource(InformationProvider rateSource);
		InformationSource.InformationSourceBuilder setRateSourcePage(RateSourcePage rateSourcePage);
		InformationSource.InformationSourceBuilder setRateSourcePageHeading(String rateSourcePageHeading);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rateSource"), processor, InformationProvider.InformationProviderBuilder.class, getRateSource());
			processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.RateSourcePageBuilder.class, getRateSourcePage());
			processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
		}
		

		InformationSource.InformationSourceBuilder prune();
	}

	/*********************** Immutable Implementation of InformationSource  ***********************/
	class InformationSourceImpl implements InformationSource {
		private final InformationProvider rateSource;
		private final RateSourcePage rateSourcePage;
		private final String rateSourcePageHeading;
		
		protected InformationSourceImpl(InformationSource.InformationSourceBuilder builder) {
			this.rateSource = ofNullable(builder.getRateSource()).map(f->f.build()).orElse(null);
			this.rateSourcePage = ofNullable(builder.getRateSourcePage()).map(f->f.build()).orElse(null);
			this.rateSourcePageHeading = builder.getRateSourcePageHeading();
		}
		
		@Override
		@RosettaAttribute("rateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSource")
		public InformationProvider getRateSource() {
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
		public InformationSource build() {
			return this;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder toBuilder() {
			InformationSource.InformationSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InformationSource.InformationSourceBuilder builder) {
			ofNullable(getRateSource()).ifPresent(builder::setRateSource);
			ofNullable(getRateSourcePage()).ifPresent(builder::setRateSourcePage);
			ofNullable(getRateSourcePageHeading()).ifPresent(builder::setRateSourcePageHeading);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InformationSource _that = getType().cast(o);
		
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
			return "InformationSource {" +
				"rateSource=" + this.rateSource + ", " +
				"rateSourcePage=" + this.rateSourcePage + ", " +
				"rateSourcePageHeading=" + this.rateSourcePageHeading +
			'}';
		}
	}

	/*********************** Builder Implementation of InformationSource  ***********************/
	class InformationSourceBuilderImpl implements InformationSource.InformationSourceBuilder {
	
		protected InformationProvider.InformationProviderBuilder rateSource;
		protected RateSourcePage.RateSourcePageBuilder rateSourcePage;
		protected String rateSourcePageHeading;
		
		@Override
		@RosettaAttribute("rateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateSource")
		public InformationProvider.InformationProviderBuilder getRateSource() {
			return rateSource;
		}
		
		@Override
		public InformationProvider.InformationProviderBuilder getOrCreateRateSource() {
			InformationProvider.InformationProviderBuilder result;
			if (rateSource!=null) {
				result = rateSource;
			}
			else {
				result = rateSource = InformationProvider.builder();
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
		public InformationSource.InformationSourceBuilder setRateSource(InformationProvider _rateSource) {
			this.rateSource = _rateSource == null ? null : _rateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateSourcePage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSourcePage")
		@Override
		public InformationSource.InformationSourceBuilder setRateSourcePage(RateSourcePage _rateSourcePage) {
			this.rateSourcePage = _rateSourcePage == null ? null : _rateSourcePage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateSourcePageHeading")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSourcePageHeading")
		@Override
		public InformationSource.InformationSourceBuilder setRateSourcePageHeading(String _rateSourcePageHeading) {
			this.rateSourcePageHeading = _rateSourcePageHeading == null ? null : _rateSourcePageHeading;
			return this;
		}
		
		@Override
		public InformationSource build() {
			return new InformationSource.InformationSourceImpl(this);
		}
		
		@Override
		public InformationSource.InformationSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InformationSource.InformationSourceBuilder prune() {
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
		public InformationSource.InformationSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InformationSource.InformationSourceBuilder o = (InformationSource.InformationSourceBuilder) other;
			
			merger.mergeRosetta(getRateSource(), o.getRateSource(), this::setRateSource);
			merger.mergeRosetta(getRateSourcePage(), o.getRateSourcePage(), this::setRateSourcePage);
			
			merger.mergeBasic(getRateSourcePageHeading(), o.getRateSourcePageHeading(), this::setRateSourcePageHeading);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InformationSource _that = getType().cast(o);
		
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
			return "InformationSourceBuilder {" +
				"rateSource=" + this.rateSource + ", " +
				"rateSourcePage=" + this.rateSourcePage + ", " +
				"rateSourcePageHeading=" + this.rateSourcePageHeading +
			'}';
		}
	}
}
