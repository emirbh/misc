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
import iso20022.auth108.mas.meta.CollateralPortfolioCode6Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CollateralPortfolioCode6Choice__1", builder=CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CollateralPortfolioCode6Choice__1", model="iso20022", builder=CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1BuilderImpl.class, version="${project.version}")
public interface CollateralPortfolioCode6Choice__1 extends RosettaModelObject {

	CollateralPortfolioCode6Choice__1Meta metaData = new CollateralPortfolioCode6Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	MarginPortfolio4__1 getMrgnPrtflCd();

	/*********************** Build Methods  ***********************/
	CollateralPortfolioCode6Choice__1 build();
	
	CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder toBuilder();
	
	static CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder builder() {
		return new CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralPortfolioCode6Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralPortfolioCode6Choice__1> getType() {
		return CollateralPortfolioCode6Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mrgnPrtflCd"), processor, MarginPortfolio4__1.class, getMrgnPrtflCd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralPortfolioCode6Choice__1Builder extends CollateralPortfolioCode6Choice__1, RosettaModelObjectBuilder {
		MarginPortfolio4__1.MarginPortfolio4__1Builder getOrCreateMrgnPrtflCd();
		@Override
		MarginPortfolio4__1.MarginPortfolio4__1Builder getMrgnPrtflCd();
		CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder setMrgnPrtflCd(MarginPortfolio4__1 mrgnPrtflCd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mrgnPrtflCd"), processor, MarginPortfolio4__1.MarginPortfolio4__1Builder.class, getMrgnPrtflCd());
		}
		

		CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of CollateralPortfolioCode6Choice__1  ***********************/
	class CollateralPortfolioCode6Choice__1Impl implements CollateralPortfolioCode6Choice__1 {
		private final MarginPortfolio4__1 mrgnPrtflCd;
		
		protected CollateralPortfolioCode6Choice__1Impl(CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder builder) {
			this.mrgnPrtflCd = ofNullable(builder.getMrgnPrtflCd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("mrgnPrtflCd")
		public MarginPortfolio4__1 getMrgnPrtflCd() {
			return mrgnPrtflCd;
		}
		
		@Override
		public CollateralPortfolioCode6Choice__1 build() {
			return this;
		}
		
		@Override
		public CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder toBuilder() {
			CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder builder) {
			ofNullable(getMrgnPrtflCd()).ifPresent(builder::setMrgnPrtflCd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolioCode6Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(mrgnPrtflCd, _that.getMrgnPrtflCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mrgnPrtflCd != null ? mrgnPrtflCd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolioCode6Choice__1 {" +
				"mrgnPrtflCd=" + this.mrgnPrtflCd +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralPortfolioCode6Choice__1  ***********************/
	class CollateralPortfolioCode6Choice__1BuilderImpl implements CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder {
	
		protected MarginPortfolio4__1.MarginPortfolio4__1Builder mrgnPrtflCd;
		
		@Override
		@RosettaAttribute("mrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("mrgnPrtflCd")
		public MarginPortfolio4__1.MarginPortfolio4__1Builder getMrgnPrtflCd() {
			return mrgnPrtflCd;
		}
		
		@Override
		public MarginPortfolio4__1.MarginPortfolio4__1Builder getOrCreateMrgnPrtflCd() {
			MarginPortfolio4__1.MarginPortfolio4__1Builder result;
			if (mrgnPrtflCd!=null) {
				result = mrgnPrtflCd;
			}
			else {
				result = mrgnPrtflCd = MarginPortfolio4__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("mrgnPrtflCd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("mrgnPrtflCd")
		@Override
		public CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder setMrgnPrtflCd(MarginPortfolio4__1 _mrgnPrtflCd) {
			this.mrgnPrtflCd = _mrgnPrtflCd == null ? null : _mrgnPrtflCd.toBuilder();
			return this;
		}
		
		@Override
		public CollateralPortfolioCode6Choice__1 build() {
			return new CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Impl(this);
		}
		
		@Override
		public CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder prune() {
			if (mrgnPrtflCd!=null && !mrgnPrtflCd.prune().hasData()) mrgnPrtflCd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMrgnPrtflCd()!=null && getMrgnPrtflCd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder o = (CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder) other;
			
			merger.mergeRosetta(getMrgnPrtflCd(), o.getMrgnPrtflCd(), this::setMrgnPrtflCd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolioCode6Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(mrgnPrtflCd, _that.getMrgnPrtflCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mrgnPrtflCd != null ? mrgnPrtflCd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolioCode6Choice__1Builder {" +
				"mrgnPrtflCd=" + this.mrgnPrtflCd +
			'}';
		}
	}
}
