package iso20022.auth108.mas;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import iso20022.auth108.mas.meta.MarginPortfolio4__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="MarginPortfolio4__1", builder=MarginPortfolio4__1.MarginPortfolio4__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="MarginPortfolio4__1", model="iso20022", builder=MarginPortfolio4__1.MarginPortfolio4__1BuilderImpl.class, version="${project.version}")
public interface MarginPortfolio4__1 extends RosettaModelObject {

	MarginPortfolio4__1Meta metaData = new MarginPortfolio4__1Meta();

	/*********************** Getter Methods  ***********************/
	PortfolioCode5Choice__1 getInitlMrgnPrtflCd();
	PortfolioCode5Choice__1 getVartnMrgnPrtflCd();

	/*********************** Build Methods  ***********************/
	MarginPortfolio4__1 build();
	
	MarginPortfolio4__1.MarginPortfolio4__1Builder toBuilder();
	
	static MarginPortfolio4__1.MarginPortfolio4__1Builder builder() {
		return new MarginPortfolio4__1.MarginPortfolio4__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginPortfolio4__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginPortfolio4__1> getType() {
		return MarginPortfolio4__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initlMrgnPrtflCd"), processor, PortfolioCode5Choice__1.class, getInitlMrgnPrtflCd());
		processRosetta(path.newSubPath("vartnMrgnPrtflCd"), processor, PortfolioCode5Choice__1.class, getVartnMrgnPrtflCd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginPortfolio4__1Builder extends MarginPortfolio4__1, RosettaModelObjectBuilder {
		PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder getOrCreateInitlMrgnPrtflCd();
		@Override
		PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder getInitlMrgnPrtflCd();
		PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder getOrCreateVartnMrgnPrtflCd();
		@Override
		PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder getVartnMrgnPrtflCd();
		MarginPortfolio4__1.MarginPortfolio4__1Builder setInitlMrgnPrtflCd(PortfolioCode5Choice__1 initlMrgnPrtflCd);
		MarginPortfolio4__1.MarginPortfolio4__1Builder setVartnMrgnPrtflCd(PortfolioCode5Choice__1 vartnMrgnPrtflCd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initlMrgnPrtflCd"), processor, PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder.class, getInitlMrgnPrtflCd());
			processRosetta(path.newSubPath("vartnMrgnPrtflCd"), processor, PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder.class, getVartnMrgnPrtflCd());
		}
		

		MarginPortfolio4__1.MarginPortfolio4__1Builder prune();
	}

	/*********************** Immutable Implementation of MarginPortfolio4__1  ***********************/
	class MarginPortfolio4__1Impl implements MarginPortfolio4__1 {
		private final PortfolioCode5Choice__1 initlMrgnPrtflCd;
		private final PortfolioCode5Choice__1 vartnMrgnPrtflCd;
		
		protected MarginPortfolio4__1Impl(MarginPortfolio4__1.MarginPortfolio4__1Builder builder) {
			this.initlMrgnPrtflCd = ofNullable(builder.getInitlMrgnPrtflCd()).map(f->f.build()).orElse(null);
			this.vartnMrgnPrtflCd = ofNullable(builder.getVartnMrgnPrtflCd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initlMrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPrtflCd")
		public PortfolioCode5Choice__1 getInitlMrgnPrtflCd() {
			return initlMrgnPrtflCd;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("vartnMrgnPrtflCd")
		public PortfolioCode5Choice__1 getVartnMrgnPrtflCd() {
			return vartnMrgnPrtflCd;
		}
		
		@Override
		public MarginPortfolio4__1 build() {
			return this;
		}
		
		@Override
		public MarginPortfolio4__1.MarginPortfolio4__1Builder toBuilder() {
			MarginPortfolio4__1.MarginPortfolio4__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginPortfolio4__1.MarginPortfolio4__1Builder builder) {
			ofNullable(getInitlMrgnPrtflCd()).ifPresent(builder::setInitlMrgnPrtflCd);
			ofNullable(getVartnMrgnPrtflCd()).ifPresent(builder::setVartnMrgnPrtflCd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginPortfolio4__1 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnPrtflCd, _that.getInitlMrgnPrtflCd())) return false;
			if (!Objects.equals(vartnMrgnPrtflCd, _that.getVartnMrgnPrtflCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnPrtflCd != null ? initlMrgnPrtflCd.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPrtflCd != null ? vartnMrgnPrtflCd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginPortfolio4__1 {" +
				"initlMrgnPrtflCd=" + this.initlMrgnPrtflCd + ", " +
				"vartnMrgnPrtflCd=" + this.vartnMrgnPrtflCd +
			'}';
		}
	}

	/*********************** Builder Implementation of MarginPortfolio4__1  ***********************/
	class MarginPortfolio4__1BuilderImpl implements MarginPortfolio4__1.MarginPortfolio4__1Builder {
	
		protected PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder initlMrgnPrtflCd;
		protected PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder vartnMrgnPrtflCd;
		
		@Override
		@RosettaAttribute("initlMrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPrtflCd")
		public PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder getInitlMrgnPrtflCd() {
			return initlMrgnPrtflCd;
		}
		
		@Override
		public PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder getOrCreateInitlMrgnPrtflCd() {
			PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder result;
			if (initlMrgnPrtflCd!=null) {
				result = initlMrgnPrtflCd;
			}
			else {
				result = initlMrgnPrtflCd = PortfolioCode5Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("vartnMrgnPrtflCd")
		public PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder getVartnMrgnPrtflCd() {
			return vartnMrgnPrtflCd;
		}
		
		@Override
		public PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder getOrCreateVartnMrgnPrtflCd() {
			PortfolioCode5Choice__1.PortfolioCode5Choice__1Builder result;
			if (vartnMrgnPrtflCd!=null) {
				result = vartnMrgnPrtflCd;
			}
			else {
				result = vartnMrgnPrtflCd = PortfolioCode5Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("initlMrgnPrtflCd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnPrtflCd")
		@Override
		public MarginPortfolio4__1.MarginPortfolio4__1Builder setInitlMrgnPrtflCd(PortfolioCode5Choice__1 _initlMrgnPrtflCd) {
			this.initlMrgnPrtflCd = _initlMrgnPrtflCd == null ? null : _initlMrgnPrtflCd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnPrtflCd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("vartnMrgnPrtflCd")
		@Override
		public MarginPortfolio4__1.MarginPortfolio4__1Builder setVartnMrgnPrtflCd(PortfolioCode5Choice__1 _vartnMrgnPrtflCd) {
			this.vartnMrgnPrtflCd = _vartnMrgnPrtflCd == null ? null : _vartnMrgnPrtflCd.toBuilder();
			return this;
		}
		
		@Override
		public MarginPortfolio4__1 build() {
			return new MarginPortfolio4__1.MarginPortfolio4__1Impl(this);
		}
		
		@Override
		public MarginPortfolio4__1.MarginPortfolio4__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginPortfolio4__1.MarginPortfolio4__1Builder prune() {
			if (initlMrgnPrtflCd!=null && !initlMrgnPrtflCd.prune().hasData()) initlMrgnPrtflCd = null;
			if (vartnMrgnPrtflCd!=null && !vartnMrgnPrtflCd.prune().hasData()) vartnMrgnPrtflCd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitlMrgnPrtflCd()!=null && getInitlMrgnPrtflCd().hasData()) return true;
			if (getVartnMrgnPrtflCd()!=null && getVartnMrgnPrtflCd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginPortfolio4__1.MarginPortfolio4__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarginPortfolio4__1.MarginPortfolio4__1Builder o = (MarginPortfolio4__1.MarginPortfolio4__1Builder) other;
			
			merger.mergeRosetta(getInitlMrgnPrtflCd(), o.getInitlMrgnPrtflCd(), this::setInitlMrgnPrtflCd);
			merger.mergeRosetta(getVartnMrgnPrtflCd(), o.getVartnMrgnPrtflCd(), this::setVartnMrgnPrtflCd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginPortfolio4__1 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnPrtflCd, _that.getInitlMrgnPrtflCd())) return false;
			if (!Objects.equals(vartnMrgnPrtflCd, _that.getVartnMrgnPrtflCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnPrtflCd != null ? initlMrgnPrtflCd.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPrtflCd != null ? vartnMrgnPrtflCd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginPortfolio4__1Builder {" +
				"initlMrgnPrtflCd=" + this.initlMrgnPrtflCd + ", " +
				"vartnMrgnPrtflCd=" + this.vartnMrgnPrtflCd +
			'}';
		}
	}
}
