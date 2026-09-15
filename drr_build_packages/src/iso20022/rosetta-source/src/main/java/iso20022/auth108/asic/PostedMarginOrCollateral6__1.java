package iso20022.auth108.asic;

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
import iso20022.auth108.asic.meta.PostedMarginOrCollateral6__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PostedMarginOrCollateral6__1", builder=PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PostedMarginOrCollateral6__1", model="iso20022", builder=PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1BuilderImpl.class, version="${project.version}")
public interface PostedMarginOrCollateral6__1 extends RosettaModelObject {

	PostedMarginOrCollateral6__1Meta metaData = new PostedMarginOrCollateral6__1Meta();

	/*********************** Getter Methods  ***********************/
	ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnPstdPreHrcut();
	ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnPstdPstHrcut();
	ActiveOrHistoricCurrencyAnd5DecimalAmount getVartnMrgnPstdPreHrcut();

	/*********************** Build Methods  ***********************/
	PostedMarginOrCollateral6__1 build();
	
	PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder toBuilder();
	
	static PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder builder() {
		return new PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PostedMarginOrCollateral6__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PostedMarginOrCollateral6__1> getType() {
		return PostedMarginOrCollateral6__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initlMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getInitlMrgnPstdPreHrcut());
		processRosetta(path.newSubPath("initlMrgnPstdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getInitlMrgnPstdPstHrcut());
		processRosetta(path.newSubPath("vartnMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getVartnMrgnPstdPreHrcut());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PostedMarginOrCollateral6__1Builder extends PostedMarginOrCollateral6__1, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnPstdPreHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnPstdPreHrcut();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnPstdPstHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnPstdPstHrcut();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateVartnMrgnPstdPreHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getVartnMrgnPstdPreHrcut();
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setInitlMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnPstdPreHrcut);
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setInitlMrgnPstdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnPstdPstHrcut);
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setVartnMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount vartnMrgnPstdPreHrcut);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initlMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getInitlMrgnPstdPreHrcut());
			processRosetta(path.newSubPath("initlMrgnPstdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getInitlMrgnPstdPstHrcut());
			processRosetta(path.newSubPath("vartnMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getVartnMrgnPstdPreHrcut());
		}
		

		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder prune();
	}

	/*********************** Immutable Implementation of PostedMarginOrCollateral6__1  ***********************/
	class PostedMarginOrCollateral6__1Impl implements PostedMarginOrCollateral6__1 {
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnPstdPreHrcut;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnPstdPstHrcut;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount vartnMrgnPstdPreHrcut;
		
		protected PostedMarginOrCollateral6__1Impl(PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder builder) {
			this.initlMrgnPstdPreHrcut = ofNullable(builder.getInitlMrgnPstdPreHrcut()).map(f->f.build()).orElse(null);
			this.initlMrgnPstdPstHrcut = ofNullable(builder.getInitlMrgnPstdPstHrcut()).map(f->f.build()).orElse(null);
			this.vartnMrgnPstdPreHrcut = ofNullable(builder.getVartnMrgnPstdPreHrcut()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initlMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnPstdPreHrcut() {
			return initlMrgnPstdPreHrcut;
		}
		
		@Override
		@RosettaAttribute("initlMrgnPstdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPstHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnPstdPstHrcut() {
			return initlMrgnPstdPstHrcut;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getVartnMrgnPstdPreHrcut() {
			return vartnMrgnPstdPreHrcut;
		}
		
		@Override
		public PostedMarginOrCollateral6__1 build() {
			return this;
		}
		
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder toBuilder() {
			PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder builder) {
			ofNullable(getInitlMrgnPstdPreHrcut()).ifPresent(builder::setInitlMrgnPstdPreHrcut);
			ofNullable(getInitlMrgnPstdPstHrcut()).ifPresent(builder::setInitlMrgnPstdPstHrcut);
			ofNullable(getVartnMrgnPstdPreHrcut()).ifPresent(builder::setVartnMrgnPstdPreHrcut);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostedMarginOrCollateral6__1 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnPstdPreHrcut, _that.getInitlMrgnPstdPreHrcut())) return false;
			if (!Objects.equals(initlMrgnPstdPstHrcut, _that.getInitlMrgnPstdPstHrcut())) return false;
			if (!Objects.equals(vartnMrgnPstdPreHrcut, _that.getVartnMrgnPstdPreHrcut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnPstdPreHrcut != null ? initlMrgnPstdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (initlMrgnPstdPstHrcut != null ? initlMrgnPstdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPstdPreHrcut != null ? vartnMrgnPstdPreHrcut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostedMarginOrCollateral6__1 {" +
				"initlMrgnPstdPreHrcut=" + this.initlMrgnPstdPreHrcut + ", " +
				"initlMrgnPstdPstHrcut=" + this.initlMrgnPstdPstHrcut + ", " +
				"vartnMrgnPstdPreHrcut=" + this.vartnMrgnPstdPreHrcut +
			'}';
		}
	}

	/*********************** Builder Implementation of PostedMarginOrCollateral6__1  ***********************/
	class PostedMarginOrCollateral6__1BuilderImpl implements PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder {
	
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder initlMrgnPstdPreHrcut;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder initlMrgnPstdPstHrcut;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder vartnMrgnPstdPreHrcut;
		
		@Override
		@RosettaAttribute("initlMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnPstdPreHrcut() {
			return initlMrgnPstdPreHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnPstdPreHrcut() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (initlMrgnPstdPreHrcut!=null) {
				result = initlMrgnPstdPreHrcut;
			}
			else {
				result = initlMrgnPstdPreHrcut = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initlMrgnPstdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPstHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnPstdPstHrcut() {
			return initlMrgnPstdPstHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnPstdPstHrcut() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (initlMrgnPstdPstHrcut!=null) {
				result = initlMrgnPstdPstHrcut;
			}
			else {
				result = initlMrgnPstdPstHrcut = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getVartnMrgnPstdPreHrcut() {
			return vartnMrgnPstdPreHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateVartnMrgnPstdPreHrcut() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (vartnMrgnPstdPreHrcut!=null) {
				result = vartnMrgnPstdPreHrcut;
			}
			else {
				result = vartnMrgnPstdPreHrcut = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("initlMrgnPstdPreHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnPstdPreHrcut")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setInitlMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount _initlMrgnPstdPreHrcut) {
			this.initlMrgnPstdPreHrcut = _initlMrgnPstdPreHrcut == null ? null : _initlMrgnPstdPreHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initlMrgnPstdPstHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnPstdPstHrcut")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setInitlMrgnPstdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount _initlMrgnPstdPstHrcut) {
			this.initlMrgnPstdPstHrcut = _initlMrgnPstdPstHrcut == null ? null : _initlMrgnPstdPstHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnPstdPreHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vartnMrgnPstdPreHrcut")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setVartnMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount _vartnMrgnPstdPreHrcut) {
			this.vartnMrgnPstdPreHrcut = _vartnMrgnPstdPreHrcut == null ? null : _vartnMrgnPstdPreHrcut.toBuilder();
			return this;
		}
		
		@Override
		public PostedMarginOrCollateral6__1 build() {
			return new PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Impl(this);
		}
		
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder prune() {
			if (initlMrgnPstdPreHrcut!=null && !initlMrgnPstdPreHrcut.prune().hasData()) initlMrgnPstdPreHrcut = null;
			if (initlMrgnPstdPstHrcut!=null && !initlMrgnPstdPstHrcut.prune().hasData()) initlMrgnPstdPstHrcut = null;
			if (vartnMrgnPstdPreHrcut!=null && !vartnMrgnPstdPreHrcut.prune().hasData()) vartnMrgnPstdPreHrcut = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitlMrgnPstdPreHrcut()!=null && getInitlMrgnPstdPreHrcut().hasData()) return true;
			if (getInitlMrgnPstdPstHrcut()!=null && getInitlMrgnPstdPstHrcut().hasData()) return true;
			if (getVartnMrgnPstdPreHrcut()!=null && getVartnMrgnPstdPreHrcut().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder o = (PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder) other;
			
			merger.mergeRosetta(getInitlMrgnPstdPreHrcut(), o.getInitlMrgnPstdPreHrcut(), this::setInitlMrgnPstdPreHrcut);
			merger.mergeRosetta(getInitlMrgnPstdPstHrcut(), o.getInitlMrgnPstdPstHrcut(), this::setInitlMrgnPstdPstHrcut);
			merger.mergeRosetta(getVartnMrgnPstdPreHrcut(), o.getVartnMrgnPstdPreHrcut(), this::setVartnMrgnPstdPreHrcut);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostedMarginOrCollateral6__1 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnPstdPreHrcut, _that.getInitlMrgnPstdPreHrcut())) return false;
			if (!Objects.equals(initlMrgnPstdPstHrcut, _that.getInitlMrgnPstdPstHrcut())) return false;
			if (!Objects.equals(vartnMrgnPstdPreHrcut, _that.getVartnMrgnPstdPreHrcut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnPstdPreHrcut != null ? initlMrgnPstdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (initlMrgnPstdPstHrcut != null ? initlMrgnPstdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPstdPreHrcut != null ? vartnMrgnPstdPreHrcut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostedMarginOrCollateral6__1Builder {" +
				"initlMrgnPstdPreHrcut=" + this.initlMrgnPstdPreHrcut + ", " +
				"initlMrgnPstdPstHrcut=" + this.initlMrgnPstdPstHrcut + ", " +
				"vartnMrgnPstdPreHrcut=" + this.vartnMrgnPstdPreHrcut +
			'}';
		}
	}
}
