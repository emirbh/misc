package fpml.consolidated.mktenv;

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
import fpml.consolidated.mktenv.meta.TermCurveMeta;
import fpml.consolidated.shared.InterpolationMethod;
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
 * Provision A curve consisting only of values over a term. This is a restricted form of One Dimensional Structure.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A curve consisting only of values over a term. This is a restricted form of One Dimensional Structure.
 *
 */
@RosettaDataType(value="TermCurve", builder=TermCurve.TermCurveBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TermCurve", model="fpml", builder=TermCurve.TermCurveBuilderImpl.class, version="2.1.1")
public interface TermCurve extends RosettaModelObject {

	TermCurveMeta metaData = new TermCurveMeta();

	/*********************** Getter Methods  ***********************/
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
	InterpolationMethod getInterpolationMethod();
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
	Boolean getExtrapolationPermitted();
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
	List<? extends TermPoint> getPoint();

	/*********************** Build Methods  ***********************/
	TermCurve build();
	
	TermCurve.TermCurveBuilder toBuilder();
	
	static TermCurve.TermCurveBuilder builder() {
		return new TermCurve.TermCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TermCurve> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TermCurve> getType() {
		return TermCurve.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.class, getInterpolationMethod());
		processor.processBasic(path.newSubPath("extrapolationPermitted"), Boolean.class, getExtrapolationPermitted(), this);
		processRosetta(path.newSubPath("point"), processor, TermPoint.class, getPoint());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TermCurveBuilder extends TermCurve, RosettaModelObjectBuilder {
		InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod();
		@Override
		InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod();
		TermPoint.TermPointBuilder getOrCreatePoint(int index);
		@Override
		List<? extends TermPoint.TermPointBuilder> getPoint();
		TermCurve.TermCurveBuilder setInterpolationMethod(InterpolationMethod interpolationMethod);
		TermCurve.TermCurveBuilder setExtrapolationPermitted(Boolean extrapolationPermitted);
		TermCurve.TermCurveBuilder addPoint(TermPoint point);
		TermCurve.TermCurveBuilder addPoint(TermPoint point, int idx);
		TermCurve.TermCurveBuilder addPoint(List<? extends TermPoint> point);
		TermCurve.TermCurveBuilder setPoint(List<? extends TermPoint> point);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.InterpolationMethodBuilder.class, getInterpolationMethod());
			processor.processBasic(path.newSubPath("extrapolationPermitted"), Boolean.class, getExtrapolationPermitted(), this);
			processRosetta(path.newSubPath("point"), processor, TermPoint.TermPointBuilder.class, getPoint());
		}
		

		TermCurve.TermCurveBuilder prune();
	}

	/*********************** Immutable Implementation of TermCurve  ***********************/
	class TermCurveImpl implements TermCurve {
		private final InterpolationMethod interpolationMethod;
		private final Boolean extrapolationPermitted;
		private final List<? extends TermPoint> point;
		
		protected TermCurveImpl(TermCurve.TermCurveBuilder builder) {
			this.interpolationMethod = ofNullable(builder.getInterpolationMethod()).map(f->f.build()).orElse(null);
			this.extrapolationPermitted = builder.getExtrapolationPermitted();
			this.point = ofNullable(builder.getPoint()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpolationMethod")
		public InterpolationMethod getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		@RosettaAttribute("extrapolationPermitted")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extrapolationPermitted")
		public Boolean getExtrapolationPermitted() {
			return extrapolationPermitted;
		}
		
		@Override
		@RosettaAttribute("point")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("point")
		public List<? extends TermPoint> getPoint() {
			return point;
		}
		
		@Override
		public TermCurve build() {
			return this;
		}
		
		@Override
		public TermCurve.TermCurveBuilder toBuilder() {
			TermCurve.TermCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TermCurve.TermCurveBuilder builder) {
			ofNullable(getInterpolationMethod()).ifPresent(builder::setInterpolationMethod);
			ofNullable(getExtrapolationPermitted()).ifPresent(builder::setExtrapolationPermitted);
			ofNullable(getPoint()).ifPresent(builder::setPoint);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TermCurve _that = getType().cast(o);
		
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(extrapolationPermitted, _that.getExtrapolationPermitted())) return false;
			if (!ListEquals.listEquals(point, _that.getPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (extrapolationPermitted != null ? extrapolationPermitted.hashCode() : 0);
			_result = 31 * _result + (point != null ? point.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermCurve {" +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"extrapolationPermitted=" + this.extrapolationPermitted + ", " +
				"point=" + this.point +
			'}';
		}
	}

	/*********************** Builder Implementation of TermCurve  ***********************/
	class TermCurveBuilderImpl implements TermCurve.TermCurveBuilder {
	
		protected InterpolationMethod.InterpolationMethodBuilder interpolationMethod;
		protected Boolean extrapolationPermitted;
		protected List<TermPoint.TermPointBuilder> point = new ArrayList<>();
		
		@Override
		@RosettaAttribute("interpolationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpolationMethod")
		public InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		public InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod() {
			InterpolationMethod.InterpolationMethodBuilder result;
			if (interpolationMethod!=null) {
				result = interpolationMethod;
			}
			else {
				result = interpolationMethod = InterpolationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("extrapolationPermitted")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extrapolationPermitted")
		public Boolean getExtrapolationPermitted() {
			return extrapolationPermitted;
		}
		
		@Override
		@RosettaAttribute("point")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("point")
		public List<? extends TermPoint.TermPointBuilder> getPoint() {
			return point;
		}
		
		@Override
		public TermPoint.TermPointBuilder getOrCreatePoint(int index) {
			if (point==null) {
				this.point = new ArrayList<>();
			}
			return getIndex(point, index, () -> {
						TermPoint.TermPointBuilder newPoint = TermPoint.builder();
						return newPoint;
					});
		}
		
		@RosettaAttribute("interpolationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interpolationMethod")
		@Override
		public TermCurve.TermCurveBuilder setInterpolationMethod(InterpolationMethod _interpolationMethod) {
			this.interpolationMethod = _interpolationMethod == null ? null : _interpolationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("extrapolationPermitted")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extrapolationPermitted")
		@Override
		public TermCurve.TermCurveBuilder setExtrapolationPermitted(Boolean _extrapolationPermitted) {
			this.extrapolationPermitted = _extrapolationPermitted == null ? null : _extrapolationPermitted;
			return this;
		}
		
		@RosettaAttribute("point")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("point")
		@Override
		public TermCurve.TermCurveBuilder addPoint(TermPoint _point) {
			if (_point != null) {
				this.point.add(_point.toBuilder());
			}
			return this;
		}
		
		@Override
		public TermCurve.TermCurveBuilder addPoint(TermPoint _point, int idx) {
			getIndex(this.point, idx, () -> _point.toBuilder());
			return this;
		}
		
		@Override
		public TermCurve.TermCurveBuilder addPoint(List<? extends TermPoint> points) {
			if (points != null) {
				for (final TermPoint toAdd : points) {
					this.point.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("point")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("point")
		@Override
		public TermCurve.TermCurveBuilder setPoint(List<? extends TermPoint> points) {
			if (points == null) {
				this.point = new ArrayList<>();
			} else {
				this.point = points.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TermCurve build() {
			return new TermCurve.TermCurveImpl(this);
		}
		
		@Override
		public TermCurve.TermCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermCurve.TermCurveBuilder prune() {
			if (interpolationMethod!=null && !interpolationMethod.prune().hasData()) interpolationMethod = null;
			point = point.stream().filter(b->b!=null).<TermPoint.TermPointBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInterpolationMethod()!=null && getInterpolationMethod().hasData()) return true;
			if (getExtrapolationPermitted()!=null) return true;
			if (getPoint()!=null && getPoint().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TermCurve.TermCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TermCurve.TermCurveBuilder o = (TermCurve.TermCurveBuilder) other;
			
			merger.mergeRosetta(getInterpolationMethod(), o.getInterpolationMethod(), this::setInterpolationMethod);
			merger.mergeRosetta(getPoint(), o.getPoint(), this::getOrCreatePoint);
			
			merger.mergeBasic(getExtrapolationPermitted(), o.getExtrapolationPermitted(), this::setExtrapolationPermitted);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TermCurve _that = getType().cast(o);
		
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(extrapolationPermitted, _that.getExtrapolationPermitted())) return false;
			if (!ListEquals.listEquals(point, _that.getPoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (extrapolationPermitted != null ? extrapolationPermitted.hashCode() : 0);
			_result = 31 * _result + (point != null ? point.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TermCurveBuilder {" +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"extrapolationPermitted=" + this.extrapolationPermitted + ", " +
				"point=" + this.point +
			'}';
		}
	}
}
